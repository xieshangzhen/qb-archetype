//代码生成时,文件路径: E:/QbRmWebDemo/src/main/java/orgauth/rmpartytyperelationrule/dao/impl/RmPartyTypeRelationRuleDao.java
//代码生成时,系统时间: 2010-11-29 10:08:24
//代码生成时,操作系统用户: Administrator

/*
 * 系统名称:单表模板 --> QbRmWebDemo
 * 
 * 文件名称: org.quickbundle.orgauth.rmpartytyperelationrule.dao.impl --> RmPartyTypeRelationRuleDao.java
 * 
 * 功能描述:
 * 
 * 版本历史: 2010-11-29 10:08:24 创建1.0.0版 (白小勇)
 *  
 */

package org.quickbundle.orgauth.rmpartytyperelationrule.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.quickbundle.base.beans.factory.RmIdFactory;
import org.quickbundle.base.dao.RmJdbcTemplate;
import org.quickbundle.tools.helper.RmPopulateHelper;
import org.quickbundle.tools.helper.RmStringHelper;
import org.springframework.jdbc.core.RowMapper;

import org.quickbundle.orgauth.rmpartytyperelationrule.dao.IRmPartyTypeRelationRuleDao;
import org.quickbundle.orgauth.rmpartytyperelationrule.util.IRmPartyTypeRelationRuleConstants;
import org.quickbundle.orgauth.rmpartytyperelationrule.vo.RmPartyTypeRelationRuleVo;

/**
 * 功能、用途、现存BUG:
 * 
 * @author 白小勇
 * @version 1.0.0
 * @see 需要参见的其它类
 * @since 1.0.0
 */

public class RmPartyTypeRelationRuleDao extends RmJdbcTemplate implements IRmPartyTypeRelationRuleDao, IRmPartyTypeRelationRuleConstants {

    /**
     * 插入单条记录，从RmIdFactory取id作主键
     * 
     * @param vo 用于添加的VO对象
     * @return 若添加成功，返回新生成的Oid
     */
    public String insert(RmPartyTypeRelationRuleVo vo) {
        String id = RmIdFactory.requestId(TABLE_NAME); //获得id
        vo.setId(id);
        Object[] obj = { vo.getId(), vo.getParty_view_id(),vo.getParent_party_type_id(),vo.getChild_party_type_id(),vo.getRule_desc(),vo.getIs_insert_child_party(),vo.getUsable_status(),vo.getModify_date(),vo.getModify_ip(),vo.getModify_user_id() };
        update(SQL_INSERT, obj);
        return id;
    }

    /**
     * 批量更新插入多条记录，用id作主键
     * 
     * @param vos 添加的VO对象数组
     * @return 若添加成功，返回新生成的id数组
     */
	public String[] insert(final RmPartyTypeRelationRuleVo[] vos) {
		String[] ids = RmIdFactory.requestId(TABLE_NAME, vos.length); //获得id
		for(int i=0; i<vos.length; i++) {
			vos[i].setId(ids[i]);
		}
		batchUpdate(SQL_INSERT, vos, new RmJdbcTemplate.CircleVoArray() {
			public Object[] getArgs(Object obj) {
				RmPartyTypeRelationRuleVo vo = (RmPartyTypeRelationRuleVo)obj;
				return new Object[]{ vo.getId(), vo.getParty_view_id(),vo.getParent_party_type_id(),vo.getChild_party_type_id(),vo.getRule_desc(),vo.getIs_insert_child_party(),vo.getUsable_status(),vo.getModify_date(),vo.getModify_ip(),vo.getModify_user_id() };
			}
		});
		return ids;
	}
	
    /**
     * 删除单条记录
     * 
     * @param id 用于删除的记录的id
     * @return 成功删除的记录数
     */
    public int delete(String id) {
        return update(SQL_DELETE_BY_ID, new Object[] { id });
    }

    /**
     * 删除多条记录
     * 
     * @param id 用于删除的记录的id
     * @return 成功删除的记录数
     */
    public int delete(String id[]) {
        String strsql = " WHERE ID IN (";
        if (id == null || id.length == 0)
            return 0;
        strsql += RmStringHelper.parseToSQLStringApos(id) + ")"; //把id数组转换为id1,id2,id3
        strsql = SQL_DELETE_MULTI_BY_IDS + strsql;
        return update(strsql);
    }

    /**
     * 根据id进行查询
     * 
     * @param id 用于查找的id
     * @return 查询到的VO对象
     */
    public RmPartyTypeRelationRuleVo find(String id) {
        return (RmPartyTypeRelationRuleVo) queryForObject(SQL_FIND_BY_ID, new Object[] { id }, new RowMapper() {
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                RmPartyTypeRelationRuleVo vo = new RmPartyTypeRelationRuleVo();
                RmPopulateHelper.populate(vo, rs);
                return vo;
            }
        });
    }

    /**
     * 更新单条记录
     * 
     * @param vo 用于更新的VO对象
     * @return 成功更新的记录数
     */
    public int update(RmPartyTypeRelationRuleVo vo) {
        Object[] obj = { vo.getParty_view_id(),vo.getParent_party_type_id(),vo.getChild_party_type_id(),vo.getRule_desc(),vo.getIs_insert_child_party(),vo.getUsable_status(),vo.getModify_date(),vo.getModify_ip(),vo.getModify_user_id(), vo.getId() };
        return update(SQL_UPDATE_BY_ID, obj);
    }

    /**
     * 批量更新修改多条记录
     * 
     * @param vos 添加的VO对象数组
     * @return 成功更新的记录数组
     */
	public int[] update(final RmPartyTypeRelationRuleVo[] vos) {
		return batchUpdate(SQL_UPDATE_BY_ID, vos, new RmJdbcTemplate.CircleVoArray() {
			public Object[] getArgs(Object obj) {
				RmPartyTypeRelationRuleVo vo = (RmPartyTypeRelationRuleVo)obj;
				return new Object[]{ vo.getParty_view_id(),vo.getParent_party_type_id(),vo.getChild_party_type_id(),vo.getRule_desc(),vo.getIs_insert_child_party(),vo.getUsable_status(),vo.getModify_date(),vo.getModify_ip(),vo.getModify_user_id(), vo.getId() };
			}
		});
	}

    /**
     * 查询总记录数，带查询条件
     * 
     * @param queryCondition 查询条件
     * @return 总记录数
     */
    public int getRecordCount(String queryCondition) {
        String strsql = SQL_COUNT + DEFAULT_SQL_WHERE_USABLE;
        if (queryCondition != null && queryCondition.trim().length() > 0) {
            strsql += DEFAULT_SQL_CONTACT_KEYWORD + queryCondition; //where后加上查询条件
        }
        return queryForInt(strsql);
    }

    /**
     * 功能: 通过查询条件获得所有的VO对象列表，带翻页，带排序字符
     *
     * @param queryCondition 查询条件, queryCondition等于null或""时查询全部
     * @param orderStr 排序字符
     * @param startIndex 开始位置(第一条是1，第二条是2...)
     * @param size 查询多少条记录(size小于等于0时,忽略翻页查询全部)
     * @param selectAllClumn 是否查询所有列，即 SELECT * FROM ...(适用于导出)
     * @return 查询到的VO列表
     */
    public List<RmPartyTypeRelationRuleVo> queryByCondition(String queryCondition, String orderStr, int startIndex, int size, boolean selectAllClumn) {
		String strsql = null;
        if(selectAllClumn) {
            strsql = SQL_QUERY_ALL_EXPORT + DEFAULT_SQL_WHERE_USABLE;
        } else {
            strsql = SQL_QUERY_ALL + DEFAULT_SQL_WHERE_USABLE;
        }
        if (queryCondition != null && queryCondition.trim().length() > 0) {
            strsql += DEFAULT_SQL_CONTACT_KEYWORD + queryCondition; //where后加上查询条件
        }
        if(orderStr != null && orderStr.trim().length() > 0) {
            strsql += ORDER_BY_SYMBOL + orderStr;
        } else {
            strsql += DEFAULT_ORDER_BY_CODE;            
        }
        
        if(size <= 0) {
            return query(strsql, new RowMapper() {
                public Object mapRow(ResultSet rs, int i) throws SQLException {
                    RmPartyTypeRelationRuleVo vo = new RmPartyTypeRelationRuleVo();
                    RmPopulateHelper.populate(vo, rs);
                    return vo;
                }
            });
        } else {
            return query(strsql, new RowMapper() {
                public Object mapRow(ResultSet rs, int i) throws SQLException {
                    RmPartyTypeRelationRuleVo vo = new RmPartyTypeRelationRuleVo();
                    RmPopulateHelper.populate(vo, rs);
                    return vo;
                }
            }, startIndex, size); 
        }
    }
}
	