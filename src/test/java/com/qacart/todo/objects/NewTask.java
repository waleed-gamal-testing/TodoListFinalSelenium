package com.qacart.todo.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewTask {
    public NewTask(String item, boolean isCompleted) {
        this.item = item;
        this.isCompleted = isCompleted;
    }
    @JsonProperty("item") // Ensure API gets the correct field name
    private String item;

    @JsonProperty("isCompleted")
    private boolean isCompleted;

    public void setItem(String item) {
        this.item = item;
    }

    public void setIsCompleted(boolean isCompleted) {
        isCompleted = isCompleted;
    }
    public String getItem() {
            return item;
        }

    public boolean getIsCompleted() {
            return isCompleted;
        }

}
