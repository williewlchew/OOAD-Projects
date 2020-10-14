package roll.store;

public class Store {
    private int[] ingredients;
    private boolean[] outages;
    private ICommand[] orders;
    private MessageBean selfBean;
    private char dummy;

    public Store(MessageBean bean){
        ingredients = new int[5];
        selfBean = bean;
        restock();
        dummy = '0';
    }

    public int getStock(int type){
        return ingredients[type];
    }

    public void getIngredients(int type){
        // decrement ingredients corresponding to type
        ingredients[type] -= 1;
        selfBean.setMessage((dummy + "-" + type));

        if(dummy == '0') dummy = '1';
        else if(dummy == '1') dummy = '0';
    }

    //wip
    public void restock(){
        for (int i = 0; i < 5; i++){
            if(ingredients[i] == 0){
                ingredients[i] = 30;
                selfBean.setMessage(dummy + "#" + i);

                if(dummy == '0') dummy = '1';
                else if(dummy == '1') dummy = '0';
            }
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
