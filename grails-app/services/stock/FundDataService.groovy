package stock

import grails.gorm.transactions.Transactional

@Transactional
class FundDataService {

    @Transactional
    def income(TransactionCmd cmd){
        Fund fund = Fund.findById(cmd.fundId)
        return saveIncomeTransaction(cmd, fund)
    }

    @Transactional
    def finalizeMoney(TransactionCmd cmd){
        Fund fund = Fund.findById(cmd.fundId)
        return saveFinalizedTransaction(cmd, fund)
    }

    @Transactional
    def transfer(TransferTransaction cmd){
        Fund fromFund = Fund.findById(cmd.fundId)
        Fund toFund = Fund.findById(cmd.anotherFund)

        saveFinalizedTransaction(cmd, fromFund, Constants.getDescriptionTransferFrom(fromFund.name))
        return saveIncomeTransaction(cmd, toFund, Constants.getDescriptionTransferTo(toFund.name))
    }

    @Transactional
    def transferDebt(TransferTransaction cmd){
        Fund fromFund = Fund.findById(cmd.fundId)
        Fund toFund = Fund.findById(cmd.anotherFund)

        saveFinalizedTransaction(cmd, fromFund, Constants.getDescriptionTransferFrom(fromFund.name), true)
        return saveIncomeTransaction(cmd, toFund, Constants.getDescriptionTransferTo(toFund.name), true)
    }

    def saveFinalizedTransaction(TransactionCmd cmd, Fund fund){
        return saveFinalizedTransaction(cmd, fund, Constants.FINALIZE_DESC)
    }
    def saveIncomeTransaction(TransactionCmd cmd, Fund fund){
        return saveIncomeTransaction(cmd, fund, Constants.INCOME_DESC)
    }
    def saveFinalizedTransaction(TransactionCmd cmd, Fund fund, String desc, isLoan = false){
        Transaction transaction = new Transaction()
        if (cmd.value > 0) {
            transaction.value = (cmd.value * -1)
        }else{
            transaction.value = cmd.value
        }
        transaction.timestamp = new Date()
        transaction.fund = fund
        transaction.comment = cmd.comment
        transaction.description = desc
        transaction.isLoan = isLoan
        if (isLoan) transaction.isFinalized = true

        return transaction.save(flush:true)
    }

    def saveIncomeTransaction(TransactionCmd cmd, Fund fund, String desc, isDept = false){
        Transaction transaction = new Transaction()
        transaction.value = cmd.value
        transaction.fund = fund
        transaction.comment = cmd.comment
        transaction.description = desc
        transaction.isDebt = isDept
        transaction.timestamp = new Date()

        return transaction.save(flush:true)
    }

}
