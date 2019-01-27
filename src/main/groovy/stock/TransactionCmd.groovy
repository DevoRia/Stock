package stock

import grails.validation.Validateable

class TransactionCmd implements Validateable {

    Long fundId
    Long value
    String comment
    Long twinTransaction
    Boolean isDebt
    Boolean isLoan

    static constraints = {
        comment nullable:true
        twinTransaction nullable:true
        isDebt nullable:true
        isLoan nullable:true
    }

}
