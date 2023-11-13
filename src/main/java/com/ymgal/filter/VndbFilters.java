package com.ymgal.filter;

import com.ymgal.model.FilterOperator;

import java.util.Arrays;
import java.util.Date;

// Not public yet
/// <summary>
/// Available Filters
/// </summary>
public class VndbFilters {
    /// <summary>
    /// Filters for Id
    /// </summary>
    public class Id extends AbstractFilter<Integer[]> {
        /// <summary>
        /// Array of valid operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual, FilterOperator.LessOrEqual, FilterOperator.LessThan,
                FilterOperator.GreaterOrEqual, FilterOperator.GreaterThan
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "id";

        Id(Integer[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Id Equals(Integer... value) {
            return new Id(value, FilterOperator.Equal);
        }

        ;

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Id NotEquals(Integer... value) {
            return new Id(value, FilterOperator.NotEqual);
        }

        ;

        /// <summary>
        /// Greater Than Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Id GreaterThan(Integer... value) {
            return new Id(value, FilterOperator.GreaterThan);
        }

        ;

        /// <summary>
        /// Greater or Equal To Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Id GreaterOrEqual(Integer... value) {
            return new Id(value, FilterOperator.GreaterOrEqual);
        }

        ;

        /// <summary>
        /// Less Than Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Id LessThan(Integer... value) {
            return new Id(value, FilterOperator.LessThan);
        }

        ;

        /// <summary>
        /// Less Than or Equal To Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Id LessOrEqual(Integer... value) {
            return new Id(value, FilterOperator.LessOrEqual);
        }

        ;

        /// <summary>
        /// Is the Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            if (this.Count > 1) // Only = and != are allowed when multiple values are passed
                return this.Operator == FilterOperator.Equal || this.Operator == FilterOperator.NotEqual;
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Alias ID Filter
    /// </summary>
    public class AliasId extends AbstractFilter<Integer[]> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "id";

        AliasId(Integer[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public AliasId Equals(Integer... value) {
            return new AliasId(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Released Filter
    /// </summary>
    public class Released extends AbstractFilter<String> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual, FilterOperator.LessOrEqual, FilterOperator.LessThan,
                FilterOperator.GreaterOrEqual, FilterOperator.GreaterThan
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "released";

        private Released(Date value, FilterOperator filterOperator) {
            super(value.toString(), filterOperator);
            this.CanBeNull = true;
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Released Equals(Date value) {
            return new Released(value, FilterOperator.Equal);
        }

        ;

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Released NotEquals(Date value) {
            return new Released(value, FilterOperator.NotEqual);
        }

        ;

        /// <summary>
        /// Greater Than Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Released GreaterThan(Date value) {
            return new Released(value, FilterOperator.GreaterThan);
        }

        ;

        /// <summary>
        /// Greater than or Equal To Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Released GreaterOrEqual(Date value) {
            return new Released(value, FilterOperator.GreaterOrEqual);
        }

        ;

        /// <summary>
        /// Less Than Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Released LessThan(Date value) {
            return new Released(value, FilterOperator.LessThan);
        }

        ;

        /// <summary>
        /// Less Than Or Equal To Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Released LessOrEqual(Date value) {
            return new Released(value, FilterOperator.LessOrEqual);
        }

        ;

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            if (this.Value == null)
                return this.Operator == FilterOperator.Equal || this.Operator == FilterOperator.NotEqual;
            return this.Operator != FilterOperator.Fuzzy;
        }
    }

    /// <summary>
    /// Languages Filter
    /// </summary>
    public class Languages extends AbstractFilter<String[]> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "languages";

        private Languages(String[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
            this.CanBeNull = true;
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Languages Equals(String... value) {
            return new Languages(value, FilterOperator.Equal);
        }

        ;

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Languages NotEquals(String... value) {
            return new Languages(value, FilterOperator.NotEqual);
        }

        ;

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Original Name Filter
    /// </summary>
    public class OriginalName extends AbstractFilter<String> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual, FilterOperator.Fuzzy
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "original";

        /// <summary>
        /// Original Name Filter
        /// </summary>
        /// <param name="value"></param>
        /// <param name="filterOperator"></param>
        public OriginalName(String value, FilterOperator filterOperator) {
            super(value, filterOperator);
            this.CanBeNull = true;
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public OriginalName Equals(String value) {
            return new OriginalName(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public OriginalName NotEquals(String value) {
            return new OriginalName(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Fuzzy Search Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public OriginalName Fuzzy(String value) {
            return new OriginalName(value, FilterOperator.Fuzzy);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            if (this.Value == null)
                return this.Operator == FilterOperator.Equal || this.Operator == FilterOperator.NotEqual;
            return this.Operator == FilterOperator.Equal || this.Operator == FilterOperator.NotEqual ||
                    this.Operator == FilterOperator.Fuzzy;
        }
    }

    /// <summary>
    /// Original Languge Filter
    /// </summary>
    public class OriginalLanguage extends AbstractFilter<String[]> {
        /// <summary>
        /// Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "orig_lang";

        private OriginalLanguage(String[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public OriginalLanguage Equals(String... value) {
            return new OriginalLanguage(value, FilterOperator.Equal);
        }

        ;

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public OriginalLanguage NotEquals(String... value) {
            return new OriginalLanguage(value, FilterOperator.NotEqual);
        }

        ;

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Platforms Filter
    /// </summary>
    public class Platforms extends AbstractFilter<String[]> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "platforms";

        private Platforms(String[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
            this.CanBeNull = true;
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Platforms Equals(String... value) {
            return new Platforms(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Platforms NotEquals(String... value) {
            return new Platforms(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Search FIlter
    /// </summary>
    public class Search extends AbstractFilter<String> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Fuzzy
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "search";

        private Search(String value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Fuzzy Search
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Search Fuzzy(String value) {
            return new Search(value, FilterOperator.Fuzzy);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(FilterOperator.Fuzzy);
        }
    }

    /// <summary>
    /// Tags Filter
    /// </summary>
    public class Tags extends AbstractFilter<Integer[]> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "tags";

        private Tags(Integer[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Tags Equals(Integer... value) {
            return new Tags(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Tags NotEquals(Integer... value) {
            return new Tags(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    // So kindly stolen from http://vndb.org/d11
    /// <summary>
    ///		<para>Find chars by traits. When providing an array of ints, the '=' filter will return chars that are linked to any (not all) of the given traits, the '!=' filter will return chars that are not linked to any of the given traits. You can combine multiple trait filters with 'and' and 'or' to get the exact behavior you need.</para>
    ///		<para>This filter may used cached data, it may take up to 24 hours before a char entry will have its traits updated with respect to this filter.</para>
    ///		<para>Chars that are linked to childs of the given trait are also included.</para>
    ///		<para>Be warned that this filter ignores spoiler settings, fetch the traits associated with the returned char to verify the spoiler level.</para>
    /// </summary>
    public class Traits extends AbstractFilter<Integer[]> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "traits";

        private Traits(Integer[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Traits Equals(Integer... value) {
            return new Traits(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Traits NotEquals(Integer... value) {
            return new Traits(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Title Filter
    /// </summary>
    public class Title extends AbstractFilter<String> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual, FilterOperator.Fuzzy
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "title";

        private Title(String value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Title Equals(String value) {
            return new Title(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equal Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Title NotEquals(String value) {
            return new Title(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Fuzzy Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Title Fuzzy(String value) {
            return new Title(value, FilterOperator.Fuzzy);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Name Filter
    /// </summary>
    public class Name extends AbstractFilter<String> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual, FilterOperator.Fuzzy
        };
        /// <summary>
        /// Valid Operators
        /// </summary>
        protected String FilterName = "name";

        private Name(String value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Name Equals(String value) {
            return new Name(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Name NotEquals(String value) {
            return new Name(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Fuzzy Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Name Fuzzy(String value) {
            return new Name(value, FilterOperator.Fuzzy);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Username Filter
    /// </summary>
    public class Username extends AbstractFilter<String[]> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual, FilterOperator.Fuzzy
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "username";

        private Username(String[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Username Equals(String... value) {
            return new Username(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Username NotEquals(String... value) {
            return new Username(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Fuzzy Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Username Fuzzy(String... value) {
            return new Username(value, FilterOperator.Fuzzy);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            if (this.Count > 1) // Only = and != are allowed when multiple values are passed
                return this.Operator == FilterOperator.Equal || this.Operator == FilterOperator.NotEqual;
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Visual Novel Filter
    /// </summary>
    public class VisualNovel extends AbstractFilter<Integer[]> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual, FilterOperator.LessOrEqual, FilterOperator.LessThan,
                FilterOperator.GreaterOrEqual, FilterOperator.GreaterThan
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "vn";

        private VisualNovel(Integer[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public VisualNovel Equals(Integer... value) {
            return new VisualNovel(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public VisualNovel NotEquals(Integer... value) {
            return new VisualNovel(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Greater Than Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public VisualNovel GreaterThan(Integer value) {
            return new VisualNovel(new Integer[]{value}, FilterOperator.GreaterThan);
        }

        /// <summary>
        /// Greater Or Equal To Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public VisualNovel GreaterOrEqual(Integer value) {
            return new VisualNovel(new Integer[]{value}, FilterOperator.GreaterOrEqual);
        }

        /// <summary>
        /// Less Than Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public VisualNovel LessThan(Integer value) {
            return new VisualNovel(new Integer[]{value}, FilterOperator.LessThan);
        }

        /// <summary>
        /// Less Than Or Equal To Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public VisualNovel LessOrEqual(Integer value) {
            return new VisualNovel(new Integer[]{value}, FilterOperator.LessOrEqual);
        }

        // This may fail on filters where vn is only =...
        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            if (this.Count > 1) // Only = and != are allowed when multiple values are passed
                return this.Operator == FilterOperator.Equal || this.Operator == FilterOperator.NotEqual;
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }

    /// <summary>
    /// Platform Filter
    /// </summary>
    public class Platform extends AbstractFilter<String[]> {
        /// <summary>
        /// Array of Valid Operators
        /// </summary>
        protected FilterOperator[] ValidOperators = {
                FilterOperator.Equal, FilterOperator.NotEqual
        };
        /// <summary>
        /// Filter Name
        /// </summary>
        protected String FilterName = "platforms";

        private Platform(String[] value, FilterOperator filterOperator) {
            super(value, filterOperator);
        }

        /// <summary>
        /// Equality Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Platform Equals(String... value) {
            return new Platform(value, FilterOperator.Equal);
        }

        /// <summary>
        /// Not Equals Filter
        /// </summary>
        /// <param name="value"></param>
        /// <returns></returns>
        public Platform NotEquals(String... value) {
            return new Platform(value, FilterOperator.NotEqual);
        }

        /// <summary>
        /// Is Filter Valid
        /// </summary>
        /// <returns></returns>
        @Override
        public Boolean IsFilterValid() {
            return Arrays.asList(this.ValidOperators).contains(this.Operator);
        }
    }
}

