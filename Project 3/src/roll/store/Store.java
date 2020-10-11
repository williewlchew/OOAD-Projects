package roll.store;

public class Store {
    private int[] ingredients;
    private boolean[] outages;
    private ICommand[] orders;
    private MessageBean selfBean;

    public Store(MessageBean bean){
        selfBean = bean;
    }

    public void getIngredients(String type){
        // decrement ingredients corresponding to type
        selfBean.setMessage(type);
    }

    public void restock(){
        for (int i = 0; i < 5; i++){
            ingredients[i] = 30;

            //reporting temp
            selfBean.setMessage("restocked");

            // not clear on outages just yet...
            //if(outages[i]){}
        }
    }

    public boolean isClosed(){
        boolean closed = false;
        for (int i = 0; i < 5; i++){
            closed = (closed | outages[i]);
        }
        return closed;
    }
}
