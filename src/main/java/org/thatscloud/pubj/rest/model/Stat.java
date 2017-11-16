package org.thatscloud.pubj.rest.model;

import java.math.BigDecimal;

import org.thatscloud.pubj.rest.model.constant.StatField;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Stat extends BaseJsonEntity
{
    private String myLabel;
    private StatField myField;
    private String myCategory;
    private BigDecimal myValueDec;
    private Long myValueInt;
    private String myValue;
    private Long myRank;
    private BigDecimal myPercentile;
    private String myDisplayValue;

    public String getLabel()
    {
        return myLabel;
    }

    public void setLabel( final String label )
    {
        myLabel = label;
    }

    public StatField getField()
    {
        return myField;
    }

    public void setField( final StatField field )
    {
        myField = field;
    }

    public String getCategory()
    {
        return myCategory;
    }

    public void setCategory( final String category )
    {
        myCategory = category;
    }

    public BigDecimal getValueDec()
    {
        return myValueDec;
    }

    public void setValueDec( final BigDecimal valueDec )
    {
        myValueDec = valueDec;
    }

    public Long getValueInt()
    {
        return myValueInt;
    }

    public void setValueInt( final Long valueInt )
    {
        myValueInt = valueInt;
    }

    public String getValue()
    {
        return myValue;
    }

    public void setValue( final String value )
    {
        myValue = value;
    }

    public Long getRank()
    {
        return myRank;
    }

    public void setRank( final Long rank )
    {
        myRank = rank;
    }

    public BigDecimal getPercentile()
    {
        return myPercentile;
    }

    public void setPercentile( final BigDecimal percentile )
    {
        myPercentile = percentile;
    }

    public String getDisplayValue()
    {
        return myDisplayValue;
    }

    public void setDisplayValue( final String displayValue )
    {
        myDisplayValue = displayValue;
    }

    @JsonIgnore
    public boolean isIntegerValue()
    {
        return myValueInt != null;
    }

    @JsonIgnore
    public boolean isDecimalValue()
    {
        return myValueDec != null;
    }
}
