/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.entities.Customer;
import data.entities.Product;
import data.entities.Productreview;

/**
 *
 * @author Steven
 */
public interface IReviewsService {
    public Productreview saveProductReview(Product product, Customer customer, String reviewText, int numberStars);
}
