package com.cts.assignment.domian;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Domain class for holding record data
 * 
 * @author Ashwarth Gangarapu
 *
 */
@XmlRootElement(name = "record")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record
{
	@XmlAttribute(name= "reference")
    private String reference;
    
	@XmlElement(name= "accountNumber")
    private String accountNumber;

	@XmlElement(name= "description")
    private String description;

	@XmlElement(name= "mutation")
    private String mutation;

	@XmlElement(name= "endBalance")
    private String endBalance;

	@XmlElement(name= "startBalance")
    private String startBalance;

    /**
	 * @param reference
	 * @param accountNumber
	 * @param description
	 * @param mutation
	 * @param endBalance
	 * @param startBalance
	 */
	public Record(String reference, String accountNumber, String description, String mutation, String endBalance,
			String startBalance) {
		super();
		this.reference = reference;
		this.accountNumber = accountNumber;
		this.description = description;
		this.mutation = mutation;
		this.endBalance = endBalance;
		this.startBalance = startBalance;
	}
	
	
	/**
	 * Default Constructor
	 */
	public Record() {
		
	}

	public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber (String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getMutation()
    {
        return mutation;
    }

    public void setMutation(String mutation)
    {
        this.mutation = mutation;
    }

    public String getEndBalance()
    {
        return endBalance;
    }

    public void setEndBalance(String endBalance)
    {
        this.endBalance = endBalance;
    }

    public String getStartBalance ()
    {
        return startBalance;
    }

    public void setStartBalance (String startBalance)
    {
        this.startBalance = startBalance;
    }

    public String getReference()
    {
        return reference;
    }

    public void setReference(String reference)
    {
        this.reference = reference;
    }

    @Override
    public String toString()
    {
        return "Record [accountNumber = "+accountNumber+", description = "+description+", mutation = "+mutation+", endBalance = "+endBalance+", startBalance = "+startBalance+", reference = "+reference+"]";
    }
}