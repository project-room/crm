package com.crm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CstScheduleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CstScheduleExample() {
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

        public Criteria andScheIdIsNull() {
            addCriterion("sche_id is null");
            return (Criteria) this;
        }

        public Criteria andScheIdIsNotNull() {
            addCriterion("sche_id is not null");
            return (Criteria) this;
        }

        public Criteria andScheIdEqualTo(Long value) {
            addCriterion("sche_id =", value, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdNotEqualTo(Long value) {
            addCriterion("sche_id <>", value, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdGreaterThan(Long value) {
            addCriterion("sche_id >", value, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sche_id >=", value, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdLessThan(Long value) {
            addCriterion("sche_id <", value, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdLessThanOrEqualTo(Long value) {
            addCriterion("sche_id <=", value, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdIn(List<Long> values) {
            addCriterion("sche_id in", values, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdNotIn(List<Long> values) {
            addCriterion("sche_id not in", values, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdBetween(Long value1, Long value2) {
            addCriterion("sche_id between", value1, value2, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheIdNotBetween(Long value1, Long value2) {
            addCriterion("sche_id not between", value1, value2, "scheId");
            return (Criteria) this;
        }

        public Criteria andScheTypeIsNull() {
            addCriterion("sche_type is null");
            return (Criteria) this;
        }

        public Criteria andScheTypeIsNotNull() {
            addCriterion("sche_type is not null");
            return (Criteria) this;
        }

        public Criteria andScheTypeEqualTo(Integer value) {
            addCriterion("sche_type =", value, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeNotEqualTo(Integer value) {
            addCriterion("sche_type <>", value, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeGreaterThan(Integer value) {
            addCriterion("sche_type >", value, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sche_type >=", value, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeLessThan(Integer value) {
            addCriterion("sche_type <", value, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sche_type <=", value, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeIn(List<Integer> values) {
            addCriterion("sche_type in", values, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeNotIn(List<Integer> values) {
            addCriterion("sche_type not in", values, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeBetween(Integer value1, Integer value2) {
            addCriterion("sche_type between", value1, value2, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sche_type not between", value1, value2, "scheType");
            return (Criteria) this;
        }

        public Criteria andScheTimeIsNull() {
            addCriterion("sche_time is null");
            return (Criteria) this;
        }

        public Criteria andScheTimeIsNotNull() {
            addCriterion("sche_time is not null");
            return (Criteria) this;
        }

        public Criteria andScheTimeEqualTo(Date value) {
            addCriterion("sche_time =", value, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeNotEqualTo(Date value) {
            addCriterion("sche_time <>", value, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeGreaterThan(Date value) {
            addCriterion("sche_time >", value, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sche_time >=", value, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeLessThan(Date value) {
            addCriterion("sche_time <", value, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeLessThanOrEqualTo(Date value) {
            addCriterion("sche_time <=", value, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeIn(List<Date> values) {
            addCriterion("sche_time in", values, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeNotIn(List<Date> values) {
            addCriterion("sche_time not in", values, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeBetween(Date value1, Date value2) {
            addCriterion("sche_time between", value1, value2, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheTimeNotBetween(Date value1, Date value2) {
            addCriterion("sche_time not between", value1, value2, "scheTime");
            return (Criteria) this;
        }

        public Criteria andScheContentIsNull() {
            addCriterion("sche_content is null");
            return (Criteria) this;
        }

        public Criteria andScheContentIsNotNull() {
            addCriterion("sche_content is not null");
            return (Criteria) this;
        }

        public Criteria andScheContentEqualTo(String value) {
            addCriterion("sche_content =", value, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentNotEqualTo(String value) {
            addCriterion("sche_content <>", value, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentGreaterThan(String value) {
            addCriterion("sche_content >", value, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentGreaterThanOrEqualTo(String value) {
            addCriterion("sche_content >=", value, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentLessThan(String value) {
            addCriterion("sche_content <", value, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentLessThanOrEqualTo(String value) {
            addCriterion("sche_content <=", value, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentLike(String value) {
            addCriterion("sche_content like", value, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentNotLike(String value) {
            addCriterion("sche_content not like", value, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentIn(List<String> values) {
            addCriterion("sche_content in", values, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentNotIn(List<String> values) {
            addCriterion("sche_content not in", values, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentBetween(String value1, String value2) {
            addCriterion("sche_content between", value1, value2, "scheContent");
            return (Criteria) this;
        }

        public Criteria andScheContentNotBetween(String value1, String value2) {
            addCriterion("sche_content not between", value1, value2, "scheContent");
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