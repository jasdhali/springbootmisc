package com.example.redis;

import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    	ObjectMapper objectMapper = new ObjectMapper();
    	String jsonValue=null;
    	try {
			jsonValue = objectMapper.writeValueAsString( student );
			System.out.println( "Student as JSON >>> " + jsonValue );
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //redisTemplate.opsForValue().set( student.getId() , jsonValue);
    	hashOps.put(KEY, student.getId(), jsonValue);
    }
 
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#updateStudent(com.example.redis.Student)
	 */
    @Override
	public void updateStudent(Student student) {
    	//find 
    	Student studentExisting = findStudent( student.getId());
    	studentExisting = new Student(studentExisting.getId(), student.getName(), student.getGender(), student.getGrade() );
    	saveStudent(studentExisting);
    }
 
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#findStudent(java.lang.String)
	 */
    @Override
	public Student findStudent(String id) {
    	ObjectMapper objectMapper = new ObjectMapper();
    	String jsonValue=null;
    	Student studentIns=null;
    	try {
			 studentIns = objectMapper.readValue( ""+hashOps.get(KEY, id) , Student.class );
			System.out.println( "Student as JSON >>> " + jsonValue );
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return studentIns;
    }
 
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#findAllStudents()
	 */
    @Override
	public Map<Object, Object> findAllStudents() {
    	Object allEntries = hashOps.entries(KEY);
        return (Map<Object, Object>)allEntries;
    }
 
    /* (non-Javadoc)
	 * @see com.example.redis.StudentRepInt#deleteStudent(java.lang.String)
	 */
    @Override
	public void deleteStudent(String id) {
        hashOps.delete(KEY, id);
    }
}