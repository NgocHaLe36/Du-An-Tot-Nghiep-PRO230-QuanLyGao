/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gao.dao.impl;

import gao.entity.Card;
import gao.entity.HoaDon;

/**
 *
 * @author lengh
 */
public interface CardDAO extends CrudDAO<Card, Integer> {

    public void deleteById(String id);

    public Card findById(String id);

}
