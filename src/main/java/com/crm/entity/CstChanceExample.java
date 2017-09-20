package com.crm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CstChanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CstChanceExample() {
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

        public Criteria andChIdIsNull() {
            addCriterion("ch_id is null");
            return (Criteria) this;
        }

        public Criteria andChIdIsNotNull() {
            addCriterion("ch_id is not null");
            return (Criteria) this;
        }

        public Criteria andChIdEqualTo(Long value) {
            addCriterion("ch_id =", value, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdNotEqualTo(Long value) {
            addCriterion("ch_id <>", value, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdGreaterThan(Long value) {
            addCriterion("ch_id >", value, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ch_id >=", value, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdLessThan(Long value) {
            addCriterion("ch_id <", value, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdLessThanOrEqualTo(Long value) {
            addCriterion("ch_id <=", value, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdIn(List<Long> values) {
            addCriterion("ch_id in", values, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdNotIn(List<Long> values) {
            addCriterion("ch_id not in", values, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdBetween(Long value1, Long value2) {
            addCriterion("ch_id between", value1, value2, "chId");
            return (Criteria) this;
        }

        public Criteria andChIdNotBetween(Long value1, Long value2) {
            addCriterion("ch_id not between", value1, value2, "chId");
            return (Criteria) this;
        }

        public Criteria andChContentIsNull() {
            addCriterion("ch_content is null");
            return (Criteria) this;
        }

        public Criteria andChContentIsNotNull() {
            addCriterion("ch_content is not null");
            return (Criteria) this;
        }

        public Criteria andChContentEqualTo(String value) {
            addCriterion("ch_content =", value, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentNotEqualTo(String value) {
            addCriterion("ch_content <>", value, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentGreaterThan(String value) {
            addCriterion("ch_content >", value, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentGreaterThanOrEqualTo(String value) {
            addCriterion("ch_content >=", value, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentLessThan(String value) {
            addCriterion("ch_content <", value, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentLessThanOrEqualTo(String value) {
            addCriterion("ch_content <=", value, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentLike(String value) {
            addCriterion("ch_content like", value, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentNotLike(String value) {
            addCriterion("ch_content not like", value, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentIn(List<String> values) {
            addCriterion("ch_content in", values, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentNotIn(List<String> values) {
            addCriterion("ch_content not in", values, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentBetween(String value1, String value2) {
            addCriterion("ch_content between", value1, value2, "chContent");
            return (Criteria) this;
        }

        public Criteria andChContentNotBetween(String value1, String value2) {
            addCriterion("ch_content not between", value1, value2, "chContent");
            return (Criteria) this;
        }

        public Criteria andChStageIsNull() {
            addCriterion("ch_stage is null");
            return (Criteria) this;
        }

        public Criteria andChStageIsNotNull() {
            addCriterion("ch_stage is not null");
            return (Criteria) this;
        }

        public Criteria andChStageEqualTo(Integer value) {
            addCriterion("ch_stage =", value, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageNotEqualTo(Integer value) {
            addCriterion("ch_stage <>", value, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageGreaterThan(Integer value) {
            addCriterion("ch_stage >", value, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageGreaterThanOrEqualTo(Integer value) {
            addCriterion("ch_stage >=", value, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageLessThan(Integer value) {
            addCriterion("ch_stage <", value, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageLessThanOrEqualTo(Integer value) {
            addCriterion("ch_stage <=", value, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageIn(List<Integer> values) {
            addCriterion("ch_stage in", values, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageNotIn(List<Integer> values) {
            addCriterion("ch_stage not in", values, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageBetween(Integer value1, Integer value2) {
            addCriterion("ch_stage between", value1, value2, "chStage");
            return (Criteria) this;
        }

        public Criteria andChStageNotBetween(Integer value1, Integer value2) {
            addCriterion("ch_stage not between", value1, value2, "chStage");
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

        public Criteria andChDateIsNull() {
            addCriterion("ch_date is null");
            return (Criteria) this;
        }

        public Criteria andChDateIsNotNull() {
            addCriterion("ch_date is not null");
            return (Criteria) this;
        }

        public Criteria andChDateEqualTo(Date value) {
            addCriterion("ch_date =", value, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateNotEqualTo(Date value) {
            addCriterion("ch_date <>", value, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateGreaterThan(Date value) {
            addCriterion("ch_date >", value, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ch_date >=", value, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateLessThan(Date value) {
            addCriterion("ch_date <", value, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateLessThanOrEqualTo(Date value) {
            addCriterion("ch_date <=", value, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateIn(List<Date> values) {
            addCriterion("ch_date in", values, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateNotIn(List<Date> values) {
            addCriterion("ch_date not in", values, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateBetween(Date value1, Date value2) {
            addCriterion("ch_date between", value1, value2, "chDate");
            return (Criteria) this;
        }

        public Criteria andChDateNotBetween(Date value1, Date value2) {
            addCriterion("ch_date not between", value1, value2, "chDate");
            return (Criteria) this;
        }

        public Criteria andChMoneyIsNull() {
            addCriterion("ch_money is null");
            return (Criteria) this;
        }

        public Criteria andChMoneyIsNotNull() {
            addCriterion("ch_money is not null");
            return (Criteria) this;
        }

        public Criteria andChMoneyEqualTo(Double value) {
            addCriterion("ch_money =", value, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyNotEqualTo(Double value) {
            addCriterion("ch_money <>", value, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyGreaterThan(Double value) {
            addCriterion("ch_money >", value, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("ch_money >=", value, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyLessThan(Double value) {
            addCriterion("ch_money <", value, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyLessThanOrEqualTo(Double value) {
            addCriterion("ch_money <=", value, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyIn(List<Double> values) {
            addCriterion("ch_money in", values, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyNotIn(List<Double> values) {
            addCriterion("ch_money not in", values, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyBetween(Double value1, Double value2) {
            addCriterion("ch_money between", value1, value2, "chMoney");
            return (Criteria) this;
        }

        public Criteria andChMoneyNotBetween(Double value1, Double value2) {
            addCriterion("ch_money not between", value1, value2, "chMoney");
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