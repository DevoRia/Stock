package stock

class Fund {

    String name
    String description
    Date timestamp

    static belongsTo = [user: User]
    static hasMany = [transactions: Transaction]

    static constraints = {
        name blank:false
        description nullable:true
    }
}
