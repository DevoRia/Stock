package stock

class MainController {

    def fundDataService

    static allowedMethods = [income: "POST", remove: "DELETE"]

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
        render view: 'transaction', model: [fundId: id, isFinal: params.isFinal]
    }

    def income(TransactionCmd cmd){
        if (!fundDataService.income(cmd)){
            render view: 'transaction', model: [fundId: cmd.fundId, isFinal: false]
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

    Long fullSum(List<Fund> funds){
        Long sum = 0
        funds.each {
            sum += it.sum()
        }
        return sum
    }
}
