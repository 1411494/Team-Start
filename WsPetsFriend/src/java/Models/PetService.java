/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
   
import java.util.Date;


/**
 *
 * @author Marco
 */
public class PetService {

    private int PetService_id;
    private String pet_id;
    private int service_id;
    private String name_service;
    private String weight;
    private Date date;
    private Date next_date;
    private double price;
    private boolean delivery;
    private String observation;
    private boolean status;

    /**
     * @return the PetService_id
     */
    public int getPetService_id() {
        return PetService_id;
    }

    /**
     * @param PetService_id the PetService_id to set
     */
    public void setPetService_id(int PetService_id) {
        this.PetService_id = PetService_id;
    }

    /**
     * @return the pet_id
     */
    public String getPet_id() {
        return pet_id;
    }

    /**
     * @param pet_id the pet_id to set
     */
    public void setPet_id(String pet_id) {
        this.pet_id = pet_id;
    }

    /**
     * @return the service_id
     */
    public int getService_id() {
        return service_id;
    }

    /**
     * @param service_id the service_id to set
     */
    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    /**
     * @return the name_service
     */
    public String getName_service() {
        return name_service;
    }

    /**
     * @param name_service the name_service to set
     */
    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

  

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the next_date
     */
    public Date getNext_date() {
        return next_date;
    }

    /**
     * @param next_date the next_date to set
     */
    public void setNext_date(Date next_date) {
        this.next_date = next_date;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the delivery
     */
    public boolean isDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    /**
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
