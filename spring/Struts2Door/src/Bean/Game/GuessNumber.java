package Bean.Game;

public class GuessNumber {
    private int answer = 0;
    private int guessNumber = 0;
    private int  guessCount = 0;
    private String result = null;

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
        guessCount ++;
        if(guessNumber == answer){
            result="You are right !";
            right = true;
        }else if(guessNumber > answer){
            result="The number is bigger";
        }else if(guessNumber < answer){
            result="The number is less";
        }
    }

//    behind auto-code

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
        guessCount = 0;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    private boolean right = false;

}
