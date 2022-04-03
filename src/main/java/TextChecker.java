public class TextChecker extends Field{
    public boolean checkField() {
        if (inputText.matches("([a-zA-Z-a-яА-я]+\\s*)+")) {
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

