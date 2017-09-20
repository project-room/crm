package com.crm.entity;

import java.util.ArrayList;
import java.util.List;

public class CstLowCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CstLowCustomerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLowCustIdIsNull() {
            addCriterion("low_cust_id is null");
            return (Criteria) this;
        }

        public Criteria andLowCustIdIsNotNull() {
            addCriterion("low_cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andLowCustIdEqualTo(Long value) {
            addCriterion("low_cust_id =", value, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdNotEqualTo(Long value) {
            addCriterion("low_cust_id <>", value, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdGreaterThan(Long value) {
            addCriterion("low_cust_id >", value, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("low_cust_id >=", value, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdLessThan(Long value) {
            addCriterion("low_cust_id <", value, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdLessThanOrEqualTo(Long value) {
            addCriterion("low_cust_id <=", value, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdIn(List<Long> values) {
            addCriterion("low_cust_id in", values, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdNotIn(List<Long> values) {
            addCriterion("low_cust_id not in", values, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdBetween(Long value1, Long value2) {
            addCriterion("low_cust_id between", value1, value2, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andLowCustIdNotBetween(Long value1, Long value2) {
            addCriterion("low_cust_id not between", value1, value2, "lowCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdIsNull() {
            addCriterion("high_cust_id is null");
            return (Criteria) this;
        }

        public Criteria andHighCustIdIsNotNull() {
            addCriterion("high_cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andHighCustIdEqualTo(Long value) {
            addCriterion("high_cust_id =", value, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdNotEqualTo(Long value) {
            addCriterion("high_cust_id <>", value, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdGreaterThan(Long value) {
            addCriterion("high_cust_id >", value, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("high_cust_id >=", value, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdLessThan(Long value) {
            addCriterion("high_cust_id <", value, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdLessThanOrEqualTo(Long value) {
            addCriterion("high_cust_id <=", value, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdIn(List<Long> values) {
            addCriterion("high_cust_id in", values, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdNotIn(List<Long> values) {
            addCriterion("high_cust_id not in", values, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdBetween(Long value1, Long value2) {
            addCriterion("high_cust_id between", value1, value2, "highCustId");
            return (Criteria) this;
        }

        public Criteria andHighCustIdNotBetween(Long value1, Long value2) {
            addCriterion("high_cust_id not between", value1, value2, "highCustId");
            return (Criteria) this;
        }

        public Criteria andCustCompanyIsNull() {
            addCriterion("cust_company is null");
            return (Criteria) this;
        }

        public Criteria andCustCompanyIsNotNull() {
            addCriterion("cust_company is not null");
            return (Criteria) this;
        }

        public Criteria andCustCompanyEqualTo(String value) {
            addCriterion("cust_company =", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyNotEqualTo(String value) {
            addCriterion("cust_company <>", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyGreaterThan(String value) {
            addCriterion("cust_company >", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("cust_company >=", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyLessThan(String value) {
            addCriterion("cust_company <", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyLessThanOrEqualTo(String value) {
            addCriterion("cust_company <=", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyLike(String value) {
            addCriterion("cust_company like", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyNotLike(String value) {
            addCriterion("cust_company not like", value, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyIn(List<String> values) {
            addCriterion("cust_company in", values, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyNotIn(List<String> values) {
            addCriterion("cust_company not in", values, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyBetween(String value1, String value2) {
            addCriterion("cust_company between", value1, value2, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustCompanyNotBetween(String value1, String value2) {
            addCriterion("cust_company not between", value1, value2, "custCompany");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(Long value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(Long value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(Long value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(Long value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(Long value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<Long> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<Long> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(Long value1, Long value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(Long value1, Long value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}