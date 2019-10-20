package vip.wukong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import vip.wukong.entity.Log;

/**
 * 日志持久层接口
 * @author 章家宝
 *
 */
public interface LogRepository extends JpaRepository<Log, Integer>, JpaSpecificationExecutor<Log> {

}
