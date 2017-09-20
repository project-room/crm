package com.crm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CstRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CstRecordExample() {
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

        public Criteria andReIdIsNull() {
            addCriterion("re_id is null");
            return (Criteria) this;
        }

        public Criteria andReIdIsNotNull() {
            addCriterion("re_id is not null");
            return (Criteria) this;
        }

        public Criteria andReIdEqualTo(Long value) {
            addCriterion("re_id =", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotEqualTo(Long value) {
            addCriterion("re_id <>", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdGreaterThan(Long value) {
            addCriterion("re_id >", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdGreaterThanOrEqualTo(Long value) {
            addCriterion("re_id >=", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdLessThan(Long value) {
            addCriterion("re_id <", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdLessThanOrEqualTo(Long value) {
            addCriterion("re_id <=", value, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdIn(List<Long> values) {
            addCriterion("re_id in", values, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotIn(List<Long> values) {
            addCriterion("re_id not in", values, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdBetween(Long value1, Long value2) {
            addCriterion("re_id between", value1, value2, "reId");
            return (Criteria) this;
        }

        public Criteria andReIdNotBetween(Long value1, Long value2) {
            addCriterion("re_id not between", value1, value2, "reId");
            return (Criteria) this;
        }

        public Criteria andReContentIsNull() {
            addCriterion("re_content is null");
            return (Criteria) this;
        }

        public Criteria andReContentIsNotNull() {
            addCriterion("re_content is not null");
            return (Criteria) this;
        }

        public Criteria andReContentEqualTo(String value) {
            addCriterion("re_content =", value, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentNotEqualTo(String value) {
            addCriterion("re_content <>", value, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentGreaterThan(String value) {
            addCriterion("re_content >", value, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentGreaterThanOrEqualTo(String value) {
            addCriterion("re_content >=", value, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentLessThan(String value) {
            addCriterion("re_content <", value, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentLessThanOrEqualTo(String value) {
            addCriterion("re_content <=", value, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentLike(String value) {
            addCriterion("re_content like", value, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentNotLike(String value) {
            addCriterion("re_content not like", value, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentIn(List<String> values) {
            addCriterion("re_content in", values, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentNotIn(List<String> values) {
            addCriterion("re_content not in", values, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentBetween(String value1, String value2) {
            addCriterion("re_content between", value1, value2, "reContent");
            return (Criteria) this;
        }

        public Criteria andReContentNotBetween(String value1, String value2) {
            addCriterion("re_content not between", value1, value2, "reContent");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andReDateIsNull() {
            addCriterion("re_date is null");
            return (Criteria) this;
        }

        public Criteria andReDateIsNotNull() {
            addCriterion("re_date is not null");
            return (Criteria) this;
        }

        public Criteria andReDateEqualTo(Date value) {
            addCriterion("re_date =", value, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateNotEqualTo(Date value) {
            addCriterion("re_date <>", value, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateGreaterThan(Date value) {
            addCriterion("re_date >", value, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateGreaterThanOrEqualTo(Date value) {
            addCriterion("re_date >=", value, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateLessThan(Date value) {
            addCriterion("re_date <", value, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateLessThanOrEqualTo(Date value) {
            addCriterion("re_date <=", value, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateIn(List<Date> values) {
            addCriterion("re_date in", values, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateNotIn(List<Date> values) {
            addCriterion("re_date not in", values, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateBetween(Date value1, Date value2) {
            addCriterion("re_date between", value1, value2, "reDate");
            return (Criteria) this;
        }

        public Criteria andReDateNotBetween(Date value1, Date value2) {
            addCriterion("re_date not between", value1, value2, "reDate");
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