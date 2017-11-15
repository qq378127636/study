package com.paic.elis.uws.sample.integration.dao.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.paic.elis.rcmp.core.util.ConstantUtils;
import com.paic.elis.uws.sample.dto.AlmightyRules;
import com.paic.elis.uws.sample.dto.AppRulecheckUnpassReason;
import com.paic.elis.uws.sample.dto.ClientInfo;
import com.paic.elis.uws.sample.dto.CurSampleTerm;
import com.paic.elis.uws.sample.dto.Plan;
import com.paic.elis.uws.sample.dto.ProfCodeTbl;
import com.paic.elis.uws.sample.dto.SampleRecordTable;
import com.paic.elis.uws.sample.dto.SampleRuleDetaAilTable;
import com.paic.elis.uws.sample.dto.SampleRuleTable;
import com.paic.elis.uws.sample.dto.SampleTermTable;
import com.paic.elis.uws.sample.dto.SamplepermissionSet;
import com.paic.elis.uws.sample.dto.StaffInfo;
import com.paic.elis.uws.sample.integration.dao.SampleDAO;
import com.paic.pafa.app.integration.dao.PafaDAOException;
import com.paic.pafa.app.lwc.core.context.support.PafaCoreContexton;
import com.paic.pafa.app.lwc.service.persistence.dao.DataAccessException;
import com.paic.pafa.biz.dao.BaseDAO;

@Component("sampleDao")
@Scope("prototype")
public class SampleDaoImpl extends BaseDAO implements SampleDAO
{

    @Override
    public String queryBarCodeNo(String barCodeNo) throws PafaDAOException
    {
        try
        {
            return  (String) getSqlMapClientTemplate().queryForObject("SAMPLERECORD.queryBarCodeNo", barCodeNo);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryBarCodeNo",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @Override
    public String queryUploadCtrlIdByBcn(String barCodeNo) throws PafaDAOException
    {
        try
        {
            return (String) getSqlMapClientTemplate().queryForObject("SAMPLERECORD.queryUploadCtrlIdByBcn", barCodeNo);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryUploadCtrlIdByBcn",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @Override
    public String queryAgentClassBank(String agentNo, String empType, DateTime appDate) throws PafaDAOException
    {
        try
        {
            Map<String, String> paraMap = new HashMap<String, String>();
            if (appDate == null)
            {
                appDate = new DateTime();
            }
            paraMap.put("agentNo", agentNo);
            paraMap.put("empType", empType);
            paraMap.put("appDate", appDate.toString("yyyyMM"));

            getSqlMapClientTemplate().queryForObject("SAMPLERECORD.queryAgentClassBank", paraMap);
            return (String) paraMap.get("agentClass");
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryAgentClassBank",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }


    @Override
    public StaffInfo queryStaffInfo(String empNo) throws PafaDAOException
    {

        try
        {
            return (StaffInfo) getSqlMapClientTemplate().queryForObject("SAMPLERECORD.queryStaffInfo", empNo);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryStaffInfo",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @Override
    public String queryAgentClassAgent(String inputType, String ctrlId, DateTime appDate) throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap = new HashMap<String, Object>();
            if (appDate == null)
            {
                appDate = new DateTime();
            }
            if (ctrlId != null && !ctrlId.isEmpty())
            {
                paraMap.put("inputType", inputType);
                paraMap.put("ctrlId", ctrlId);
                paraMap.put("appDate", appDate.toDate());
                getSqlMapClientTemplate().queryForObject("SAMPLERECORD.queryAgentClassAgent", paraMap);
                return (String) paraMap.get("agentClass");
            }
            else
            {
                return null;
            }
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryAgentClassAgent",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> querySampleRuleByAgentClass(Map<String, Object> paraMap) throws PafaDAOException
    {
        try
        {
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.querySampleRuleByAgentClass", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "querySampleRuleByAgentClass",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @Override
    public String queryUploadResult(String uploadStageCtrlId) throws PafaDAOException
    {
        try
        {
            return (String) getSqlMapClientTemplate().queryForObject("RULECHECKAPP.queryUploadResult" ,uploadStageCtrlId);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryUploadResult",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @Override
    public String queryIsSampleResult(String uploadStageCtrlId) throws PafaDAOException
    {
        try
        {
            return (String) getSqlMapClientTemplate().queryForObject("RULECHECKAPP.queryIsSampleResult" , uploadStageCtrlId );
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryIsSampleResult",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Map<String, Object>> querySpotcheckResult(Map<String, Object> paraMap) throws PafaDAOException
    {
        try
        {
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.querySpotcheckResult", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "querySpotcheckResult",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Plan> queryAppBenAll(String ctrlId) throws PafaDAOException
    {
        try
        {
            return  getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryAppBenAll", ctrlId);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryAppBenAll",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ClientInfo> queryApplicant(String ctrlId) throws PafaDAOException
    {
        try
        {
            return  getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryApplicant", ctrlId);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryApplicant",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRecordTable> queryExistsSampleRec(String barCodeNo, String clientNo, String sampleSequence)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("barCodeNo", barCodeNo);
            paraMap.put("clientNo", clientNo);
            paraMap.put("sampleSequence", sampleSequence);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryExistsSampleRec", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryExistsSampleRec",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRecordTable> queryExistsSampleRecByAppNo(String applicationNo, String clientNo, String sampleSequence)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("appNo", applicationNo);
            paraMap.put("clientNo", clientNo);
            paraMap.put("sampleSequence", sampleSequence);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryExistsSampleRecByAppNo", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryExistsSampleRecByAppNo",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AppRulecheckUnpassReason> queryExistsUnpassRec(String ctrlId, String clientNo, String clientType,
            String unpassCause, String reasonDescription) throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("ctrlId", ctrlId);
            paraMap.put("clientNo", clientNo);
            paraMap.put("clientType", clientType);
            paraMap.put("unpassCause", unpassCause);
            paraMap.put("reasonDescription", reasonDescription);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryExistsUnpassRec", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryExistsUnpassRec",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<AlmightyRules> queryAlmightyRules(String ruleId, String regionCode, DateTime date)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("ruleId", ruleId);
            paraMap.put("regionCode",regionCode );
            paraMap.put("date", date.toString("yyyyMMdd"));
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryAlmightyRules", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryAlmightyRules",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleTable> queryCurSample(Date appDate, String agentNo, String deptno, String regionCode)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("appDate", appDate);
            paraMap.put("agentNo", agentNo);
            paraMap.put("deptno", deptno);
            paraMap.put("regionCode", regionCode);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurSample", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurSample",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SamplepermissionSet> querySamplePermissionSet(String regionCode) throws PafaDAOException
    {
        try
        {
            return  getSqlMapClientTemplate().queryForList("SAMPLERECORD.querySamplePermissionSet", regionCode);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "querySamplePermissionSet",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleTermTable> queryCurTermClass(String sampleSequece) throws PafaDAOException
    {
        try
        {
            return  getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurTermClass", sampleSequece);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurTermClass",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CurSampleTerm> queryCurSampleTerm(String sampleSequece, String termClass) throws PafaDAOException
    {
        
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("sampleSequece", sampleSequece);
            paraMap.put("termClass", termClass);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurSampleTerm", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurSampleTerm",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleDetaAilTable> queryCurRegionCode(String sampleSequece, String sampleTerm, String regionCode)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap =new HashMap<String, Object>();
            paraMap.put("sampleSequece", sampleSequece);
            paraMap.put("sampleTerm", sampleTerm);
            paraMap.put("regionCode", regionCode);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurRegionCode", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurRegionCode",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleDetaAilTable> queryCurDeptno(String sampleSequece, String sampleTerm, String deptNo)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap =new HashMap<String, Object>();
            paraMap.put("sampleSequece", sampleSequece);
            paraMap.put("sampleTerm", sampleTerm);
            paraMap.put("deptNo", deptNo);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurDeptno", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurDeptno",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleDetaAilTable> queryCurOther(String sampleSequence, String sampleTerm, String agentNo)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("sampleSequence", sampleSequence);
            paraMap.put("sampleTerm", sampleTerm);
            paraMap.put("data", agentNo);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurOther", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurOther",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleDetaAilTable> queryCurOtherNumber(String sampleSequece, String sampleTerm, Integer age)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("sampleSequece", sampleSequece);
            paraMap.put("sampleTerm", sampleTerm);
            paraMap.put("data", age);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurOtherNumber", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurOtherNumber",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleDetaAilTable> queryCurClientSex(String sampleSequece, String sampleTerm, String sex)
            throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("sampleSequece", sampleSequece);
            paraMap.put("sampleTerm", sampleTerm);
            paraMap.put("data", sex);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurClientSex", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurClientSex",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProfCodeTbl> queryCurProfGrade(String profCode) throws PafaDAOException
    {
        try
        {
            return  getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurProfGrade", profCode);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurProfGrade",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleDetaAilTable> queryCurOtherNumber(String sampleSequece, String sampleTerm,
            BigDecimal riskSumins) throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("sampleSequece", sampleSequece);
            paraMap.put("sampleTerm", sampleTerm);
            paraMap.put("data", riskSumins);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurOtherNumber", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurOtherNumber",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleDetaAilTable> queryCurPlanSumins(String sampleSequece, String sampleTerm, String planCode,
            BigDecimal sumIns) throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("sampleSequece", sampleSequece);
            paraMap.put("sampleTerm", sampleTerm);
            paraMap.put("planCode", planCode);
            paraMap.put("data", sumIns);
            return getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurPlanSumins", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurPlanSumins",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SampleRuleTable> queryCurSample2(Date appDate) throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("appDate", appDate);
            return  getSqlMapClientTemplate().queryForList("SAMPLERECORD.queryCurSample2", paraMap);
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "queryCurSample2",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }

    @Override
    public String quertParentRegionCode(String regionCode, String secondRegionCode, String errorCode,
            String errorMessage) throws PafaDAOException
    {
        try
        {
            Map<String, Object> paraMap=new HashMap<String, Object>();
            paraMap.put("regionCode", regionCode);
            paraMap.put("regionGrade", 2);
            paraMap.put("errorCode", errorCode);
            paraMap.put("errorMessage", errorMessage);
            getSqlMapClientTemplate().queryForObject("SAMPLERECORD.quertParentRegionCode", paraMap);
            return (String)  paraMap.get("secondRegionCode");
        }
        catch(DataAccessException e)
        {
            logger.error(e.getErrorCode(), e);
            String txnId = PafaCoreContexton.getInstance().getThreadContext().getTxnID();
            throw new PafaDAOException(txnId, this.getClass().getName(), "quertParentRegionCode",
                    ConstantUtils.RCMP_DAO_INFO_QUERY_FAILD, e);
        }
    }


}
