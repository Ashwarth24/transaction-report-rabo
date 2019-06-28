package com.cts.assignment.domian;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Domain class for holding {@link List} of {@link Record}'s
 * 
 * @author Ashwarth Gangarapu
 *
 */
@XmlRootElement(name = "records")
@XmlAccessorType(XmlAccessType.FIELD)
public class Records
{
	@XmlElement(name = "record")
    private List<Record> record;

    public List<Record> getRecord()
    {
        return record;
    }

    public void setRecord(List<Record> record)
    {
        this.record = record;
    }

    @Override
    public String toString()
    {
        return "Records [record = "+record+"]";
    }
}