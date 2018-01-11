package com.example.redis;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
	
 
    /*public StudentRepositoryImpl() {
		super();
	}*/

	private static final String KEY = "Student";
     
    private RedisTemplate<String, Object> redisTemplate;
    
    private HashOperations hashOps;
 
    @Autowired
    public StudentRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
 
    @PostConstruct
    private void init() {
        hashOps = redisTemplate.opsForHash();
    }
     
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#saveStudent(com.example.redis.Student)
	 */
    @Override
	public void saveStudent(Student student) {
        //hashOps.put(KEY, student.getId(), student);
        redisTemplate.opsForValue().set( student.getId() , student);
    }
 
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#updateStudent(com.example.redis.Student)
	 */
    @Override
	public void updateStudent(Student student) {
        hashOps.put(KEY, student.getId(), student);
    }
 
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#findStudent(java.lang.String)
	 */
    @Override
	public Student findStudent(String id) {
        return (Student) hashOps.get(KEY, id);
    }
 
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#findAllStudents()
	 */
    @Override
	public Map<Object, Object> findAllStudents() {
        return hashOps.entries(KEY);
    }
 
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#deleteStudent(java.lang.String)
	 */
    @Override
	public void deleteStudent(String id) {
        hashOps.delete(KEY, id);
    }
}