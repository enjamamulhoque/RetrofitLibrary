package com.enjamamulhoque.retrofitlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    Button getAllTodosBtn, getTodosUsingRouteParaBtn, getTodoUsingQueryBtn, postTodoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllTodosBtn = findViewById(R.id.button);
        getTodosUsingRouteParaBtn = findViewById(R.id.button2);
        getTodoUsingQueryBtn = findViewById(R.id.button3);
        postTodoBtn = findViewById(R.id.button4);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        getAllTodosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<List<Todo>> call = apiInterface.getTodos();
                call.enqueue(new Callback<List<Todo>>() {
                    @Override
                    public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {

                        Toast.makeText(MainActivity.this, "Todos: " + response.body(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<List<Todo>> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

        getTodosUsingRouteParaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Todo> call = apiInterface.getTodo(2);
                call.enqueue(new Callback<Todo>() {
                    @Override
                    public void onResponse(Call<Todo> call, Response<Todo> response) {

                        Toast.makeText(MainActivity.this, "Todos: " + response.body(), Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<Todo> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });

        getTodoUsingQueryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<List<Todo>> call = apiInterface.getTodoUsingQuery(4, true);
                call.enqueue(new Callback<List<Todo>>() {
                    @Override
                    public void onResponse(Call<List<Todo>> call, Response<List<Todo>> response) {

                        Toast.makeText(MainActivity.this, "Todos: " + response.body(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<List<Todo>> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });

        postTodoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Todo todo = new Todo(3,"This is Enjamamul Hoque", true);
                Call<Todo> call = apiInterface.postTodo(todo);
                call.enqueue(new Callback<Todo>() {
                    @Override
                    public void onResponse(Call<Todo> call, Response<Todo> response) {

                        Toast.makeText(MainActivity.this, "Todos: " + response.body(), Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<Todo> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });




    }
}