package com.crm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysDynamicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysDynamicExample() {
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

        public Criteria andDyIdIsNull() {
            addCriterion("dy_id is null");
            return (Criteria) this;
        }

        public Criteria andDyIdIsNotNull() {
            addCriterion("dy_id is not null");
            return (Criteria) this;
        }

        public Criteria andDyIdEqualTo(Long value) {
            addCriterion("dy_id =", value, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdNotEqualTo(Long value) {
            addCriterion("dy_id <>", value, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdGreaterThan(Long value) {
            addCriterion("dy_id >", value, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dy_id >=", value, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdLessThan(Long value) {
            addCriterion("dy_id <", value, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdLessThanOrEqualTo(Long value) {
            addCriterion("dy_id <=", value, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdIn(List<Long> values) {
            addCriterion("dy_id in", values, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdNotIn(List<Long> values) {
            addCriterion("dy_id not in", values, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdBetween(Long value1, Long value2) {
            addCriterion("dy_id between", value1, value2, "dyId");
            return (Criteria) this;
        }

        public Criteria andDyIdNotBetween(Long value1, Long value2) {
            addCriterion("dy_id not between", value1, value2, "dyId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andDyContentIsNull() {
            addCriterion("dy_content is null");
            return (Criteria) this;
        }

        public Criteria andDyContentIsNotNull() {
            addCriterion("dy_content is not null");
            return (Criteria) this;
        }

        public Criteria andDyContentEqualTo(String value) {
            addCriterion("dy_content =", value, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentNotEqualTo(String value) {
            addCriterion("dy_content <>", value, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentGreaterThan(String value) {
            addCriterion("dy_content >", value, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentGreaterThanOrEqualTo(String value) {
            addCriterion("dy_content >=", value, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentLessThan(String value) {
            addCriterion("dy_content <", value, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentLessThanOrEqualTo(String value) {
            addCriterion("dy_content <=", value, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentLike(String value) {
            addCriterion("dy_content like", value, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentNotLike(String value) {
            addCriterion("dy_content not like", value, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentIn(List<String> values) {
            addCriterion("dy_content in", values, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentNotIn(List<String> values) {
            addCriterion("dy_content not in", values, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentBetween(String value1, String value2) {
            addCriterion("dy_content between", value1, value2, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyContentNotBetween(String value1, String value2) {
            addCriterion("dy_content not between", value1, value2, "dyContent");
            return (Criteria) this;
        }

        public Criteria andDyDateIsNull() {
            addCriterion("dy_date is null");
            return (Criteria) this;
        }

        public Criteria andDyDateIsNotNull() {
            addCriterion("dy_date is not null");
            return (Criteria) this;
        }

        public Criteria andDyDateEqualTo(Date value) {
            addCriterion("dy_date =", value, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateNotEqualTo(Date value) {
            addCriterion("dy_date <>", value, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateGreaterThan(Date value) {
            addCriterion("dy_date >", value, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("dy_date >=", value, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateLessThan(Date value) {
            addCriterion("dy_date <", value, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateLessThanOrEqualTo(Date value) {
            addCriterion("dy_date <=", value, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateIn(List<Date> values) {
            addCriterion("dy_date in", values, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateNotIn(List<Date> values) {
            addCriterion("dy_date not in", values, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateBetween(Date value1, Date value2) {
            addCriterion("dy_date between", value1, value2, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyDateNotBetween(Date value1, Date value2) {
            addCriterion("dy_date not between", value1, value2, "dyDate");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIsNull() {
            addCriterion("dy_classify is null");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIsNotNull() {
            addCriterion("dy_classify is not null");
            return (Criteria) this;
        }

        public Criteria andDyClassifyEqualTo(Integer value) {
            addCriterion("dy_classify =", value, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyNotEqualTo(Integer value) {
            addCriterion("dy_classify <>", value, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyGreaterThan(Integer value) {
            addCriterion("dy_classify >", value, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("dy_classify >=", value, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyLessThan(Integer value) {
            addCriterion("dy_classify <", value, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyLessThanOrEqualTo(Integer value) {
            addCriterion("dy_classify <=", value, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIn(List<Integer> values) {
            addCriterion("dy_classify in", values, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyNotIn(List<Integer> values) {
            addCriterion("dy_classify not in", values, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyBetween(Integer value1, Integer value2) {
            addCriterion("dy_classify between", value1, value2, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyNotBetween(Integer value1, Integer value2) {
            addCriterion("dy_classify not between", value1, value2, "dyClassify");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdIsNull() {
            addCriterion("dy_classify_id is null");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdIsNotNull() {
            addCriterion("dy_classify_id is not null");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdEqualTo(Long value) {
            addCriterion("dy_classify_id =", value, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdNotEqualTo(Long value) {
            addCriterion("dy_classify_id <>", value, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdGreaterThan(Long value) {
            addCriterion("dy_classify_id >", value, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dy_classify_id >=", value, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdLessThan(Long value) {
            addCriterion("dy_classify_id <", value, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdLessThanOrEqualTo(Long value) {
            addCriterion("dy_classify_id <=", value, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdIn(List<Long> values) {
            addCriterion("dy_classify_id in", values, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdNotIn(List<Long> values) {
            addCriterion("dy_classify_id not in", values, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdBetween(Long value1, Long value2) {
            addCriterion("dy_classify_id between", value1, value2, "dyClassifyId");
            return (Criteria) this;
        }

        public Criteria andDyClassifyIdNotBetween(Long value1, Long value2) {
            addCriterion("dy_classify_id not between", value1, value2, "dyClassifyId");
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