package fr.sy43.studzero.sqlite.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class represents a budget
 */
public class Budget {
    /**
     * id of the budget
     */
    private int idBudget;
    /**
     * Start date of the budget
     */
    private Date dateStart;
    /**
     * End date of the budget
     */
    private Date dateEnd;
    /**
     * Amount of money of the budget
     */
    private float budgetAmount;

    /**
     * Default constructor of the class
     */
    public Budget() {
        this.idBudget = 0;
        this.dateStart = new Date();
        Calendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        calendar.setTime(dateStart);
        calendar.add(Calendar.DATE, 30);
        // DateEnd = dateStart + 30 days
        this.dateEnd = calendar.getTime();
        this.budgetAmount = 0;
    }

    /**
     * Constructor of the class
     * @param idBudget
     * @param dateStart
     * @param dateEnd
     * @param budgetAmount
     */
    public Budget(int idBudget, Date dateStart, Date dateEnd, float budgetAmount) {
        this.idBudget = idBudget;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.budgetAmount = budgetAmount;
    }

    /**
     * Constructor of the class
     * @param dateStart
     * @param dateEnd
     * @param budgetAmount
     */
    public Budget(Date dateStart, Date dateEnd, float budgetAmount) {
        this.idBudget = 0;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.budgetAmount = budgetAmount;
    }

    /**
     * @return id of the budget
     */
    public int getIdBudget() {
        return idBudget;
    }

    /**
     * Set the id of budget
     * @param idBudget
     */
    public void setIdBudget(int idBudget) {
        this.idBudget = idBudget;
    }

    /**
     * @return start date of the budget
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * Set the start date of the budget
     * @param dateStart
     */
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * @return end date of the budget
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * Set end date of the budget
     * @param dateEnd
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * @return the amount of money used for the budget
     */
    public float getBudgetAmount() {
        return budgetAmount;
    }

    /**
     * Set the budget amount
     * @param budgetAmount
     */
    public void setBudgetAmount(float budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    /**
     * @return the day after the end of the budget
     */
    public Date getDateNextBudget() {
        Calendar calendar = (GregorianCalendar) GregorianCalendar.getInstance();
        calendar.setTime(dateEnd);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }
}
