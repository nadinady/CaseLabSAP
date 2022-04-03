public class EmailChecker extends Field {
    public boolean checkField() {
        if (inputText.matches("[a-zA-Z0-9_-]+@{1}[a-zA-Z0-9_]+\\.{1}[a-zA-Z]+")) {
            return true;
        }
        else return false;
    }
    public void printField ()
    {
        System.out.println(inputText);
    }
    public String getInputText()
    { return inputText;}
}
