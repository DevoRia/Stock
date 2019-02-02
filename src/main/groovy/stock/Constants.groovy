package stock

class Constants {

    static String INCOME_DESC = "Income"
    static String FINALIZE_DESC = "Finalized"

    static String getDescriptionTransferTo(String fundName){
        return "Transferred to ${ fundName }"
    }

    static String getDescriptionTransferFrom(String fundName){
        return "Transferred from ${ fundName }"

    }
}
