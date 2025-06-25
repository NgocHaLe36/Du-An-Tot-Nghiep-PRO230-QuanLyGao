/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gao.dao.impl;

import gao.entity.Gao;
import gao.entity.LoaiGao;
import java.util.List;

/**
 *
 * @author lengh
 */
public interface LoaiGaoDAO extends CrudDAO<LoaiGao, String>{
    public List<Gao> findByLoaiId(String maLoai);

}
