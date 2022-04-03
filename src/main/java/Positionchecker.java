public class Positionchecker extends Field {
    public boolean  checkField() {
        if (inputText.matches("[1-4]+")) {
            return true;
        }
        else return false;
    }
    public void printField () {
        System.out.println(inputText);
    }
    public String getInputText()
    { return inputText;}
}
