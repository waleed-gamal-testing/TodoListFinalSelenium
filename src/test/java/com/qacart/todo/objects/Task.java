package com.qacart.todo.objects;

public class Task {
    public Task(String item , boolean isCompleted)
    {
        this.item = item ;
        this.isCompleted = isCompleted ;
    }
    private String item ;
    private boolean isCompleted ;

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
       this.isCompleted = completed;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


}
