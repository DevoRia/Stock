package stock

class Fund {

    Long id
    String name
    String description
    Date timestamp

    static belongsTo = [user: User]
    static hasMany = [transactions: Transaction]

    static constraints = {
        name blank:false
        description nullable:true
        timestamp nullable:true
        user nullable:true
    }

    def sum() {
        Long sum = 0
        this.transactions.each {
            sum += it.value
        }
        return sum
    }

    def count() {
        return findAllByUser(this.user).size()
    }

}
