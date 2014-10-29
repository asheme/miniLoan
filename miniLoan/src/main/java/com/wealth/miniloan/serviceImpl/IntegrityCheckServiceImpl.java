package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wealth.miniloan.dao.IntegrityCheckCfgDao;
import com.wealth.miniloan.dao.IntegrityCheckDao;
import com.wealth.miniloan.entity.InteCheckExtend;
import com.wealth.miniloan.entity.MlInteCheckInfo;
import com.wealth.miniloan.entity.MlInteCheckInfoExample;
import com.wealth.miniloan.entity.MlInteCheckItem;
import com.wealth.miniloan.entity.MlInteCheckItemExample;
import com.wealth.miniloan.service.IntegrityCheckServiceI;
import com.wealth.miniloan.utils.Constant;

@Service(value="integrityCheckService")
public class IntegrityCheckServiceImpl implements IntegrityCheckServiceI {
	private IntegrityCheckCfgDao integrityCheckCfgDao;
	private IntegrityCheckDao integrityCheckDao;

	@Autowired
	public void setIntegrityCheckCfgDao(IntegrityCheckCfgDao integrityCheckCfgDao) {
		this.integrityCheckCfgDao = integrityCheckCfgDao;
	}

	@Autowired
	public void setIntegrityCheckDao(IntegrityCheckDao integrityCheckDao) {
		this.integrityCheckDao = integrityCheckDao;
	}

	@Override
	public List<InteCheckExtend> getIntegrityCheckList(String appNo,String appType) {
		List<InteCheckExtend> integrityCheckList= null;
		InteCheckExtend inteCheckExtend=null;
		MlInteCheckItem inteCheckItem = null;
		
		MlInteCheckItemExample itemExample = new MlInteCheckItemExample();
		MlInteCheckItemExample.Criteria itemCriteria= itemExample.createCriteria();
		if(Constant.APP_TYPE_NATURAL.equals(appType)){
			itemCriteria.andItemTypeEqualTo(Constant.INTE_CHECK_ITEM_TYPE_NATURAL);
		}else{
			itemCriteria.andItemTypeEqualTo(Constant.INTE_CHECK_ITEM_TYPE_CORP);
		}
		itemCriteria.andStatusEqualTo(Constant.STATUS_ENABLE);
		List<MlInteCheckItem> integrityCheckItemList= this.integrityCheckCfgDao.findAll(itemExample);
		
		MlInteCheckInfoExample checkExample = new MlInteCheckInfoExample();
		MlInteCheckInfoExample.Criteria checkCriteria= checkExample.createCriteria();
		checkCriteria.andAppNoEqualTo(appNo);
		List<MlInteCheckInfo> integrityCheckInfoList= this.integrityCheckDao.findAll(checkExample);
		if(integrityCheckInfoList!=null && integrityCheckInfoList.size()>0){
			if(integrityCheckItemList!=null && integrityCheckItemList.size()>0){
				integrityCheckList=new ArrayList<InteCheckExtend>();				
				for(int i=0;i<integrityCheckItemList.size();++i){
					inteCheckItem=integrityCheckItemList.get(i);
					inteCheckExtend=new InteCheckExtend();
					inteCheckExtend.setItemId(inteCheckItem.getItemId());
					inteCheckExtend.setItemName(inteCheckItem.getItemName());
					inteCheckExtend.setItemDesc(inteCheckItem.getItemDesc());
					inteCheckExtend.setResult(getIntegrityCheckResult(inteCheckItem.getItemId(),integrityCheckInfoList));
					integrityCheckList.add(inteCheckExtend);				
				}
			}
		}else{
			if(integrityCheckItemList!=null && integrityCheckItemList.size()>0){
				integrityCheckList=new ArrayList<InteCheckExtend>();				
				for(int i=0;i<integrityCheckItemList.size();++i){
					inteCheckItem=integrityCheckItemList.get(i);
					inteCheckExtend=new InteCheckExtend();
					inteCheckExtend.setItemId(inteCheckItem.getItemId());
					inteCheckExtend.setItemName(inteCheckItem.getItemName());
					inteCheckExtend.setItemDesc(inteCheckItem.getItemDesc());
					integrityCheckList.add(inteCheckExtend);				
				}
			}
		}		
		
		return integrityCheckList;
	}	

	/**
	 * 通过itemId查询检查项的结果
	 * @param itemId
	 * @param integrityCheckInfoList
	 * @return
	 */
	private String getIntegrityCheckResult(long itemId,List<MlInteCheckInfo> integrityCheckInfoList){
		String result=null;
		MlInteCheckInfo inteCheckInfo=null;
		
		if(integrityCheckInfoList!=null && integrityCheckInfoList.size()>0){
			for(int i =0 ;i<integrityCheckInfoList.size();++i){
				inteCheckInfo=integrityCheckInfoList.get(i); 
				if(itemId == inteCheckInfo.getItemId()){
					result=inteCheckInfo.getResult();
					break;
				}
			}
		}
		
		return result;
	}

	@Override
	public boolean saveIntegrityCheck(String appNo,String appType,String inteCheckStr) {
		MlInteCheckItem inteCheckItem=null;
		MlInteCheckInfo inteCheckInfo=null;
		boolean result= false;
		
		try {
			System.out.println("===============>>>>appNo:"+appNo);
			System.out.println("===============>>>>appType:"+appType);
			System.out.println("===============>>>>inteCheckStr:"+inteCheckStr);
			MlInteCheckItemExample itemExample = new MlInteCheckItemExample();
			MlInteCheckItemExample.Criteria itemCriteria= itemExample.createCriteria();
			if(Constant.APP_TYPE_NATURAL.equals(appType)){
				itemCriteria.andItemTypeEqualTo(Constant.INTE_CHECK_ITEM_TYPE_NATURAL);
			} else {
				itemCriteria.andItemTypeEqualTo(Constant.INTE_CHECK_ITEM_TYPE_CORP);
			}
			itemCriteria.andStatusEqualTo(Constant.STATUS_ENABLE);
			List<MlInteCheckItem> integrityCheckItemList= this.integrityCheckCfgDao.findAll(itemExample);
			
			MlInteCheckInfoExample checkExample = new MlInteCheckInfoExample();
			MlInteCheckInfoExample.Criteria checkCriteria= checkExample.createCriteria();
			checkCriteria.andAppNoEqualTo(appNo);
			this.integrityCheckDao.deleteByExample(checkExample);

			String[] inteChecks = inteCheckStr.split(",");		
			if(integrityCheckItemList!=null && integrityCheckItemList.size()>0){
				for(int i=0;i<integrityCheckItemList.size();++i){
					inteCheckItem=(MlInteCheckItem)integrityCheckItemList.get(i);
					inteCheckInfo=new MlInteCheckInfo();
					inteCheckInfo.setAppNo(appNo);
					inteCheckInfo.setItemId(inteCheckItem.getItemId());
					inteCheckInfo.setItemName(inteCheckItem.getItemName());
					inteCheckInfo.setResult(getInteChectResultFromForm(inteCheckItem.getItemName(),inteChecks));
					this.integrityCheckDao.save(inteCheckInfo);
				}
			}
			
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * 通过form串行化串获取完整性检查项的结果
	 * @param inteCheckItemName
	 * @param inteChecks
	 * @return
	 */
	private String getInteChectResultFromForm(String inteCheckItemName,String[] inteChecks){
		String inteCheckResult=null;
		String[] inteCheckItemObj=null;
		
		for(int i=0;i<inteChecks.length;++i){
			inteCheckItemObj=inteChecks[i].split(":");
			if(inteCheckItemObj[0].trim().equals(inteCheckItemName)){
				inteCheckResult=inteCheckItemObj[1].trim();
				break;
			}
		}
		
		return inteCheckResult;
	}
}
