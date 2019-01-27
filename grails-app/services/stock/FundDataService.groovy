package stock

import grails.gorm.transactions.Transactional

@Transactional
class FundDataService {

    @Transactional
    def income(TransactionCmd cmd){
        Fund fund = Fund.findById(cmd.fundId)
        Transaction transaction = new Transaction()
        transaction.value = cmd.value
        transaction.fund = fund
        transaction.comment = cmd.comment
        transaction.description = Constants.INCOME_DESC

        return transaction.save()
    }

}
