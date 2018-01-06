-------------------------------------------------------流程部署

--流程定义表
select * from act_re_procdef  for update

-- 流程部署对象表
select * from act_re_deployment  for update --order by id_ asc

--资源文件表
select * from act_ge_bytearray  for update

--主键生成策略表
select * from act_ge_property

------------------------------------------------------流程实例
--流程实例历史表
select * from act_hi_procinst order by start_time_ 


-----------------------------------------------------任务
--正在执行的任务信息表
select * from act_ru_task 

--任务执行的对象
select * from act_ru_execution 

--已经完成的任务历史表（某一次流程的执行一共经历了多少个任务）
select * from act_hi_taskinst 

--所有活动节点的历史表（某一次流程的执行一共经历了多少个活动）
select * from act_hi_actinst  

----------------------------------------------------变量
--正在执行的流程变量表
select * from act_ru_variable

--流程变量历史表
select * from act_hi_varinst


-----------------------------------------------------任务办理人
--组任务班里人
select * from act_ru_identitylink 

--历史的组任务班里人
select * from act_hi_identitylink 


----------------------------------------------------角色组
--角色组表
select * from act_id_group

--用户表
select * from act_id_user

--角色用户关联表
select * from act_id_membership


select * from a_employee for update
select * from a_leavebill for update

	create sequence a_leavebill_s --序列名     
	increment by 1       -- 每次加几个     
	start with 1    -- 从1开始计数     
	maxvalue 9999999999999999999999999999     --最大值     
	minvalue 1     --最小值     
	cycle      --循环使用，到达最大值或者最小值时，从新建立对象     

  select a_leavebill_s.nextval from dual
  



