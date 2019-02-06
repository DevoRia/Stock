package stock

class MainController {

    def fundDataService

    def index() {

        List<Fund> funds = Fund.findAll()

        render view: 'index', model: [funds: funds, sum: fullSum(funds)]
    }

    def fullSum(List<Fund> funds){
        Long sum = 0
        funds.each {
            sum += it.sum()
        }
        return sum
    }
}
