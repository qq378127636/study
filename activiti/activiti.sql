-------------------------------------------------------���̲���

--���̶����
select * from act_re_procdef  for update

-- ���̲�������
select * from act_re_deployment  for update --order by id_ asc

--��Դ�ļ���
select * from act_ge_bytearray  for update

--�������ɲ��Ա�
select * from act_ge_property

------------------------------------------------------����ʵ��
--����ʵ����ʷ��
select * from act_hi_procinst order by start_time_ 


-----------------------------------------------------����
--����ִ�е�������Ϣ��
select * from act_ru_task 

--����ִ�еĶ���
select * from act_ru_execution 

--�Ѿ���ɵ�������ʷ��ĳһ�����̵�ִ��һ�������˶��ٸ�����
select * from act_hi_taskinst 

--���л�ڵ����ʷ��ĳһ�����̵�ִ��һ�������˶��ٸ����
select * from act_hi_actinst  

----------------------------------------------------����
--����ִ�е����̱�����
select * from act_ru_variable

--���̱�����ʷ��
select * from act_hi_varinst


-----------------------------------------------------���������
--�����������
select * from act_ru_identitylink 

--��ʷ�������������
select * from act_hi_identitylink 


----------------------------------------------------��ɫ��
--��ɫ���
select * from act_id_group

--�û���
select * from act_id_user

--��ɫ�û�������
select * from act_id_membership


select * from a_employee for update
select * from a_leavebill for update

	create sequence a_leavebill_s --������     
	increment by 1       -- ÿ�μӼ���     
	start with 1    -- ��1��ʼ����     
	maxvalue 9999999999999999999999999999     --���ֵ     
	minvalue 1     --��Сֵ     
	cycle      --ѭ��ʹ�ã��������ֵ������Сֵʱ�����½�������     

  select a_leavebill_s.nextval from dual
  



