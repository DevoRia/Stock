package stock

class TransferTransaction extends TransactionCmd{

    Long anotherFund

    static constraints = {
        anotherFund nullable:true
    }

}
