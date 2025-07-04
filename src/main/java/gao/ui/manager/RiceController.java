/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gao.ui.manager;

import gao.entity.Gao;
import gao.ui.manager.CrudController;

/**
 *
 * @author lengh
 */
public interface RiceController extends CrudController<Gao>{
    void fillCategories();
    void chooseFile();
}
