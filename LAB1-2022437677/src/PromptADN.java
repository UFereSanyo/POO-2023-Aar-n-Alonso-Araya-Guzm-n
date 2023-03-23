public class PromptADN {

    private String prompt;

    public PromptADN(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public String toString() {
        return "PromptADN{" +
                "prompt='" + prompt + '\'' +
                '}';
    }
}
