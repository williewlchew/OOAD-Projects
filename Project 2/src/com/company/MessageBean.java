package com.company;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

// http://www.javaquizplayer.com/blogposts/java-propertychangelistener-as-observer-19.html
public class MessageBean {

    private int intMessage;
    private String strMessage;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public int getIntMessage() {
        return this.intMessage;
    }

    public String getStrMessage() {
        return this.strMessage;
    }

    public void setMessage(int newValue) {
        int oldValue = this.intMessage;
        this.intMessage = newValue;
        // The parameter values of firePropertyChange method
        // constitute the PropertyChangeEvent object
        support.firePropertyChange("message", oldValue, newValue);
    }

    public void setMessage(String newValue) {
        String oldValue = this.strMessage;
        this.strMessage = newValue;
        // The parameter values of firePropertyChange method
        // constitute the PropertyChangeEvent object
        support.firePropertyChange("message", oldValue, newValue);
    }
}
