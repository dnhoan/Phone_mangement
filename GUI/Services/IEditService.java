/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Services;

public interface IEditService<Entity> {
    abstract public void init();
    abstract public Entity getForm();
    abstract public void setForm(Entity entity);
    abstract public void updateStatus();
    abstract public void insert();
    abstract public void update();
    abstract public void delete();
    abstract public void edit();
    abstract public void clearForm();
    abstract public void fillTable();
    abstract public void first();
    abstract public void last();
    abstract public void next();
    abstract public void previous();
    boolean validateForm(boolean isEdit);
}
