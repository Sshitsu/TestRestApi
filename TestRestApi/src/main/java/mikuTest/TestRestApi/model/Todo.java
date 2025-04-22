package mikuTest.TestRestApi.model;

import mikuTest.TestRestApi.entity.TodoEntity;

public class Todo {
    private Long id;
    private String title;
    private Boolean completed;
    private String description;



    public static Todo toModel(TodoEntity entity){
        Todo model = new Todo();
        model.setTitle(entity.getTitle());
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setDescription(entity.getDescription());
        return model;
    }
    public Todo(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
