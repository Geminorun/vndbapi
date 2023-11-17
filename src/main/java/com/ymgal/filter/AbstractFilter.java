package com.ymgal.filter;

import com.ymgal.Interfaces.IFilter;
import com.ymgal.model.FilterOperator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    protected T[] ValueArr;
    /// <summary>
    ///		If an array is passed, the number of items.
    /// </summary>
    protected Integer Count;
    /// <summary>
    /// If the filter is an array
    /// </summary>
    protected Boolean IsArray;
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

        if (!this.IsArray)
            return this.Type == String.class
                    ? res + "\"" + this.Value + "\""
                    : res + this.Value;

        if (this.Count == 1 && this.IsArray) {
            List<?> ts = Arrays.asList(this.ValueArr);
            return this.Type == String.class
                    ? res + "\"" + ts.get(0) + "\""
                    : res + ts.get(0);
        }
        // Doesn't use the Contract Resolver, Some things *may* be funky,
        // but should be fine for value types like Int32 / String
        return res + Arrays.asList(this.ValueArr).stream().map(x -> x.toString()).collect(Collectors.joining(","));
    }

    @Override
    public Boolean IsFilterValid() {
        return null;
    }
}
