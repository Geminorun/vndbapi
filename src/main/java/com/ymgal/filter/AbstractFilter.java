package com.ymgal.filter;

import com.ymgal.Interfaces.IFilter;
import com.ymgal.model.FilterOperator;

/**
 * @Auther: lyl
 * @Date: 2023/11/13 15:17
 * @Description:
 */
public abstract class AbstractFilter<T> implements IFilter {

    /// <summary>
    /// The operators that are allowed for the Filter
    /// </summary>
    protected FilterOperator[] ValidOperators;
    /// <summary>
    /// Can Be Null
    /// </summary>
    protected Boolean CanBeNull = false;
    /// <summary>
    /// The selected FilterOperator
    /// </summary>
    protected FilterOperator Operator;
    /// <summary>
    /// Value
    /// </summary>
    protected T Value;
    /// <summary>
    ///		If an array is passed, the number of items.
    /// </summary>
    protected Integer Count;

    /// <summary>
    /// The name of the Filter
    /// </summary>
    private Class<?> Type;

    protected AbstractFilter(T value, FilterOperator filterOperator) {
        this.Value = value;
        this.Operator = filterOperator;
        this.Type = value.getClass();
    }


    public abstract String getFilterName();

    @Override
    public String toString() {
        String res = this.getFilterName() + this.Operator;

        if (this.CanBeNull && (this.Value == null))
            return res + "null";

        return this.Type == String.class
                ? res + "\"" + this.Value + "\""
                : res + this.Value;
    }

    @Override
    public Boolean IsFilterValid() {
        return null;
    }
}
