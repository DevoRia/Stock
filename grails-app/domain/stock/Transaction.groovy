package stock


class Transaction {

    Long id
    Double value
    String description
    String comment
    Long twinTransaction
    Boolean isFinalized = false
    Boolean isDebt = false
    Boolean isLoan = false
    Date timestamp

    static belongsTo = [fund: Fund]

    static constraints = {
        comment nullable:true
        twinTransaction nullable:true
        timestamp nullable:true
    }

}
