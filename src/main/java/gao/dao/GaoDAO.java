/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gao.dao.impl;

import gao.entity.Gao;
import java.util.List;

/**
 *
 * @author lengh
 */
public interface GaoDAO extends CrudDAO<Gao, String>{
    public List<Gao> findByLoaiId(String maLoai);

}
