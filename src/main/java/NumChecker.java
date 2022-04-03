public class NumChecker extends Field{
    public boolean  checkField() {
        if (inputText.matches("[0-9]+")) {
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

