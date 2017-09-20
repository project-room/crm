package com.crm.entity;

import java.util.ArrayList;
import java.util.List;

public class CstCustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CstCustomerExample() {
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

        public Criteria andCustNameIsNull() {
            addCriterion("cust_name is null");
            return (Criteria) this;
        }

        public Criteria andCustNameIsNotNull() {
            addCriterion("cust_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustNameEqualTo(String value) {
            addCriterion("cust_name =", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotEqualTo(String value) {
            addCriterion("cust_name <>", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThan(String value) {
            addCriterion("cust_name >", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameGreaterThanOrEqualTo(String value) {
            addCriterion("cust_name >=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThan(String value) {
            addCriterion("cust_name <", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLessThanOrEqualTo(String value) {
            addCriterion("cust_name <=", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameLike(String value) {
            addCriterion("cust_name like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotLike(String value) {
            addCriterion("cust_name not like", value, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameIn(List<String> values) {
            addCriterion("cust_name in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotIn(List<String> values) {
            addCriterion("cust_name not in", values, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameBetween(String value1, String value2) {
            addCriterion("cust_name between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustNameNotBetween(String value1, String value2) {
            addCriterion("cust_name not between", value1, value2, "custName");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNull() {
            addCriterion("cust_phone is null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIsNotNull() {
            addCriterion("cust_phone is not null");
            return (Criteria) this;
        }

        public Criteria andCustPhoneEqualTo(String value) {
            addCriterion("cust_phone =", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotEqualTo(String value) {
            addCriterion("cust_phone <>", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThan(String value) {
            addCriterion("cust_phone >", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("cust_phone >=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThan(String value) {
            addCriterion("cust_phone <", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLessThanOrEqualTo(String value) {
            addCriterion("cust_phone <=", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneLike(String value) {
            addCriterion("cust_phone like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotLike(String value) {
            addCriterion("cust_phone not like", value, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneIn(List<String> values) {
            addCriterion("cust_phone in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotIn(List<String> values) {
            addCriterion("cust_phone not in", values, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneBetween(String value1, String value2) {
            addCriterion("cust_phone between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustPhoneNotBetween(String value1, String value2) {
            addCriterion("cust_phone not between", value1, value2, "custPhone");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNull() {
            addCriterion("cust_email is null");
            return (Criteria) this;
        }

        public Criteria andCustEmailIsNotNull() {
            addCriterion("cust_email is not null");
            return (Criteria) this;
        }

        public Criteria andCustEmailEqualTo(String value) {
            addCriterion("cust_email =", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotEqualTo(String value) {
            addCriterion("cust_email <>", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThan(String value) {
            addCriterion("cust_email >", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailGreaterThanOrEqualTo(String value) {
            addCriterion("cust_email >=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThan(String value) {
            addCriterion("cust_email <", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLessThanOrEqualTo(String value) {
            addCriterion("cust_email <=", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailLike(String value) {
            addCriterion("cust_email like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotLike(String value) {
            addCriterion("cust_email not like", value, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailIn(List<String> values) {
            addCriterion("cust_email in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotIn(List<String> values) {
            addCriterion("cust_email not in", values, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailBetween(String value1, String value2) {
            addCriterion("cust_email between", value1, value2, "custEmail");
            return (Criteria) this;
        }

        public Criteria andCustEmailNotBetween(String value1, String value2) {
            addCriterion("cust_email not between", value1, value2, "custEmail");
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

        public Criteria andCustAddressIsNull() {
            addCriterion("cust_address is null");
            return (Criteria) this;
        }

        public Criteria andCustAddressIsNotNull() {
            addCriterion("cust_address is not null");
            return (Criteria) this;
        }

        public Criteria andCustAddressEqualTo(String value) {
            addCriterion("cust_address =", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotEqualTo(String value) {
            addCriterion("cust_address <>", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressGreaterThan(String value) {
            addCriterion("cust_address >", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressGreaterThanOrEqualTo(String value) {
            addCriterion("cust_address >=", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLessThan(String value) {
            addCriterion("cust_address <", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLessThanOrEqualTo(String value) {
            addCriterion("cust_address <=", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressLike(String value) {
            addCriterion("cust_address like", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotLike(String value) {
            addCriterion("cust_address not like", value, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressIn(List<String> values) {
            addCriterion("cust_address in", values, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotIn(List<String> values) {
            addCriterion("cust_address not in", values, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressBetween(String value1, String value2) {
            addCriterion("cust_address between", value1, value2, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustAddressNotBetween(String value1, String value2) {
            addCriterion("cust_address not between", value1, value2, "custAddress");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIsNull() {
            addCriterion("cust_industry is null");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIsNotNull() {
            addCriterion("cust_industry is not null");
            return (Criteria) this;
        }

        public Criteria andCustIndustryEqualTo(String value) {
            addCriterion("cust_industry =", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotEqualTo(String value) {
            addCriterion("cust_industry <>", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryGreaterThan(String value) {
            addCriterion("cust_industry >", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("cust_industry >=", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLessThan(String value) {
            addCriterion("cust_industry <", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLessThanOrEqualTo(String value) {
            addCriterion("cust_industry <=", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryLike(String value) {
            addCriterion("cust_industry like", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotLike(String value) {
            addCriterion("cust_industry not like", value, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryIn(List<String> values) {
            addCriterion("cust_industry in", values, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotIn(List<String> values) {
            addCriterion("cust_industry not in", values, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryBetween(String value1, String value2) {
            addCriterion("cust_industry between", value1, value2, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustIndustryNotBetween(String value1, String value2) {
            addCriterion("cust_industry not between", value1, value2, "custIndustry");
            return (Criteria) this;
        }

        public Criteria andCustPicIsNull() {
            addCriterion("cust_pic is null");
            return (Criteria) this;
        }

        public Criteria andCustPicIsNotNull() {
            addCriterion("cust_pic is not null");
            return (Criteria) this;
        }

        public Criteria andCustPicEqualTo(String value) {
            addCriterion("cust_pic =", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicNotEqualTo(String value) {
            addCriterion("cust_pic <>", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicGreaterThan(String value) {
            addCriterion("cust_pic >", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicGreaterThanOrEqualTo(String value) {
            addCriterion("cust_pic >=", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicLessThan(String value) {
            addCriterion("cust_pic <", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicLessThanOrEqualTo(String value) {
            addCriterion("cust_pic <=", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicLike(String value) {
            addCriterion("cust_pic like", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicNotLike(String value) {
            addCriterion("cust_pic not like", value, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicIn(List<String> values) {
            addCriterion("cust_pic in", values, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicNotIn(List<String> values) {
            addCriterion("cust_pic not in", values, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicBetween(String value1, String value2) {
            addCriterion("cust_pic between", value1, value2, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustPicNotBetween(String value1, String value2) {
            addCriterion("cust_pic not between", value1, value2, "custPic");
            return (Criteria) this;
        }

        public Criteria andCustSalesIsNull() {
            addCriterion("cust_sales is null");
            return (Criteria) this;
        }

        public Criteria andCustSalesIsNotNull() {
            addCriterion("cust_sales is not null");
            return (Criteria) this;
        }

        public Criteria andCustSalesEqualTo(String value) {
            addCriterion("cust_sales =", value, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesNotEqualTo(String value) {
            addCriterion("cust_sales <>", value, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesGreaterThan(String value) {
            addCriterion("cust_sales >", value, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesGreaterThanOrEqualTo(String value) {
            addCriterion("cust_sales >=", value, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesLessThan(String value) {
            addCriterion("cust_sales <", value, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesLessThanOrEqualTo(String value) {
            addCriterion("cust_sales <=", value, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesLike(String value) {
            addCriterion("cust_sales like", value, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesNotLike(String value) {
            addCriterion("cust_sales not like", value, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesIn(List<String> values) {
            addCriterion("cust_sales in", values, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesNotIn(List<String> values) {
            addCriterion("cust_sales not in", values, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesBetween(String value1, String value2) {
            addCriterion("cust_sales between", value1, value2, "custSales");
            return (Criteria) this;
        }

        public Criteria andCustSalesNotBetween(String value1, String value2) {
            addCriterion("cust_sales not between", value1, value2, "custSales");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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