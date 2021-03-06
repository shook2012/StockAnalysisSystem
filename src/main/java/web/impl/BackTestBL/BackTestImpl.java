package web.impl.BackTestBL;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import web.Tools.backtesting.BackTesting;
import web.Tools.strategy_module.RookieModule;
import web.dao.BackTestBL.BackTestMapper;
import web.pojo.after.BackTestResultPo;
import web.service.BackTestBL.BackTestService;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by linyufan on 16/9/7.
 */

@Service("backTestImpl")
public class BackTestImpl implements BackTestService{

    @Resource
    public BackTestMapper backTestMapper;

    @Override
    public BackTestResultPo runJsonBackTest(String strategyid, String userid, String startdate, String enddate, ArrayList<String> stocklist) {
        String resultid = backTestMapper.getResultid(userid,strategyid,startdate, enddate);
        String error = new String();
        if(resultid==null) {
            String json = backTestMapper.getJson(userid, strategyid);
            RookieModule rookieModule = new RookieModule(json, stocklist);
            String python = rookieModule.getCode();
            backTestMapper.setPython(userid, strategyid, python);

            BackTesting backTesting = null;
            try {
                backTesting = new BackTesting(Integer.valueOf(strategyid), Integer.valueOf(userid), startdate, enddate);
                error = backTesting.runBacktesting();
                if(error.startsWith("1")){
                    return new BackTestResultPo(1,error);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

            resultid = backTestMapper.getResultid(userid, strategyid, startdate, enddate);
        }

        BackTestResultPo backTestResultPo = new BackTestResultPo(startdate,enddate, LocalDate.now().toString(),userid,strategyid,resultid);
        String listname = "result_" + resultid;
        backTestResultPo.resultdatas = backTestMapper.getResult(listname);

        return backTestResultPo;
    }

    @Override
    public BackTestResultPo runJsonBackTest(String strategyid, String userid, String startdate, String enddate, ArrayList<String> stocklist, int initmoney) {
        String resultid = backTestMapper.getResultid(userid,strategyid,startdate, enddate);
        String error = new String();
        if(resultid==null) {
            String json = backTestMapper.getJson(userid, strategyid);
            RookieModule rookieModule = new RookieModule(json, stocklist);
            String python = rookieModule.getCode();
            backTestMapper.setPython(userid, strategyid, python);

            BackTesting backTesting = null;
            try {
                backTesting = new BackTesting(Integer.valueOf(strategyid), Integer.valueOf(userid), startdate, enddate,initmoney);
                error = backTesting.runBacktesting();
                if(error.startsWith("1")){
                    return new BackTestResultPo(1,error);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

            resultid = backTestMapper.getResultid(userid, strategyid, startdate, enddate);
        }

        BackTestResultPo backTestResultPo = new BackTestResultPo(startdate,enddate, LocalDate.now().toString(),userid,strategyid,resultid);
        String listname = "result_" + resultid;
        backTestResultPo.resultdatas = backTestMapper.getResult(listname);

        return backTestResultPo;
    }

    @Override
    public BackTestResultPo runPythonBackTest(String strategyid, String userid, String startdate, String enddate) {
        String resultid = backTestMapper.getResultid(userid,strategyid,startdate, enddate);
        String error = new String();
        if(resultid==null) {

            BackTesting backTesting = null;
            try {
                backTesting = new BackTesting(Integer.valueOf(strategyid), Integer.valueOf(userid), startdate, enddate);
//                System.out.println("here1");
                backTesting.runBacktesting();
//                System.out.println("here2");
                if(error.startsWith("1")){
                    return new BackTestResultPo(1,error);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//            System.out.println("here3");

            resultid = backTestMapper.getResultid(userid, strategyid, startdate, enddate);
        }
        BackTestResultPo backTestResultPo = new BackTestResultPo(startdate,enddate, LocalDate.now().toString(),userid,strategyid,resultid);
        String listname = "result_" + resultid;
        backTestResultPo.resultdatas = backTestMapper.getResult(listname);

        return backTestResultPo;
    }

    @Override
    public BackTestResultPo runPythonBackTest(String strategyid, String userid, String startdate, String enddate, int initmoney) {
        String resultid = backTestMapper.getResultid(userid,strategyid,startdate, enddate);
        String error = new String();
        if(resultid==null) {

            BackTesting backTesting = null;
            try {
                backTesting = new BackTesting(Integer.valueOf(strategyid), Integer.valueOf(userid), startdate, enddate,initmoney);
//                System.out.println("here1");
                backTesting.runBacktesting();
//                System.out.println("here2");
                if(error.startsWith("1")){
                    return new BackTestResultPo(1,error);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//            System.out.println("here3");

            resultid = backTestMapper.getResultid(userid, strategyid, startdate, enddate);
        }
        BackTestResultPo backTestResultPo = new BackTestResultPo(startdate,enddate, LocalDate.now().toString(),userid,strategyid,resultid);
        String listname = "result_" + resultid;
        backTestResultPo.resultdatas = backTestMapper.getResult(listname);

        return backTestResultPo;
    }
}
