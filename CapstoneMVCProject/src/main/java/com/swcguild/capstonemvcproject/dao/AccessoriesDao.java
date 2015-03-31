/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.capstonemvcproject.dao;

import com.swcguild.capstonemvcproject.dto.Category;
import com.swcguild.capstonemvcproject.dto.HashTag;
import com.swcguild.capstonemvcproject.dto.Image;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface AccessoriesDao {
//    Category Methods
    public Category addCategory(Category category);
    public List<Category> getAllCategories();
    public Category getCategoryByCategoryId(int categoryId);
    public void editCategory(Category category);
    public void deleteCategory(int categoryId);
    
//    HashTag Methods
    public HashTag addHashTag(HashTag hashTag);
    public HashTag getHashTagById(int hashTagId);
    public List<HashTag> getAllHashTags();
    public void editHashTag(HashTag hashTag);
    public void deleteHashTag(int hashTagId);
    
//    Image Methods
    public Image addImage(Image image);
    public Image getImageById(int imageId);
    public List<Image> getAllImages();
    public void editImage(Image image);
    public void deleteImage(int imageId);
    
}
