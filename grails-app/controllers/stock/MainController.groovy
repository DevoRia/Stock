package stock

class MainController {

    def fundDataService

    static allowedMethods = [income: "POST", transferTo: "POST", remove: "DELETE"]

    def index() {
        List<Fund> funds = Fund.findAll()
        render view: 'index', model: [funds: funds, sum: fullSum(funds)]
    }

    def details(Long id) {
        Fund fund = Fund.findById(id)
        List<Transaction> transactions = Transaction.findAllByFund(fund)
        render view: 'details', model: [fund: fund, transactions: transactions]
    }

    def transaction(Long id) {
        Boolean isFinal = null
        if(params.isFinal){
            isFinal = true
        }
        render view: 'transaction', model: [fundId: id, isFinal:isFinal]
    }

    def income(TransactionCmd cmd){
        if (!fundDataService.income(cmd)){
            render view: 'transaction', model: [fundId: cmd.fundId]
        }else{
            details(cmd.fundId)
        }
    }

    def finalizeMoney(TransactionCmd cmd){
        if (!fundDataService.finalizeMoney(cmd)){
            render view: 'transaction', model: [fundId: cmd.fundId, isFinal: true]
        }else{
            details(cmd.fundId)
        }
    }

    def transfer(Long id){
        render view: 'transfer', model: [fundId: id]
    }

    def transferTo(TransferTransaction cmd){
        println cmd
        if (!fundDataService.transfer(cmd)){
            render view: 'transfer', model: [fundId: cmd.fundId]
        }else{
            details(cmd.fundId)
        }
    }

    Long fullSum(List<Fund> funds){
        Long sum = 0
        funds.each {
            sum += it.sum()
        }
        return sum
    }
}
